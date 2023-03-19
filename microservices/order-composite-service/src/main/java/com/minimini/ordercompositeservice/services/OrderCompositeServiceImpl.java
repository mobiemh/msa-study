package com.minimini.ordercompositeservice.services;

import com.minimini.api.composite.order.OrderAggregate;
import com.minimini.api.composite.order.OrderCompositeService;
import com.minimini.api.core.order.Order;
import com.minimini.api.core.user.User;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.function.Supplier;

@RestController
@RequiredArgsConstructor
public class OrderCompositeServiceImpl implements OrderCompositeService {
    private final StreamBridge streamBridge;
    private String orderServiceUrl = "http://localhost:8081/order";
    private String userServiceUrl = "http://localhost:8084/user";

    @Bean
    public Supplier<Message<Integer>> test() {
        return () -> MessageBuilder.withPayload(Integer.valueOf(12)).build();
    }

   // @Bean
   // public Supplier<Message<OrderAggregate>> createOrder() {
   //     return () -> MessageBuilder.withPayload(new OrderAggregate(new Order("hello", "world"), new User("mini"))).build();
   // }

    @Override
    public void createOrderAggregate(OrderAggregate orderAggregate) {
        var b = MessageBuilder.withPayload(orderAggregate).build();
        boolean ret = streamBridge.send("createOrder-out-0", b, MimeTypeUtils.APPLICATION_JSON);
        System.out.println(ret);
    }

    @Override
    public Mono<OrderAggregate> getOrderAggregate(int orderId) {
        URI getOrderUri = UriComponentsBuilder.fromUriString(orderServiceUrl + "/{orderId}").build(1);
        URI getUserUri = UriComponentsBuilder.fromUriString(userServiceUrl + "/{userId}").build(1);

        return Mono.zip(values -> new OrderAggregate((Order) values[0], (User) values[1]),
                WebClient.builder().build().get().uri(getOrderUri)
                            .retrieve().bodyToMono(Order.class)
                            .onErrorReturn(CallNotPermittedException.class, getOrderFallBackValue(orderId)),
                        WebClient.builder().build().get().uri(getUserUri)
                            .retrieve().bodyToMono(User.class));
    }

    private Order getOrderFallBackValue(int orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        if(orderId % 10 == 0) {
            order.setOrderId(9999);
        }
        return order;
    }
}
