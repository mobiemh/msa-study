package com.minimini.ordercompositeservice.services;

import com.minimini.api.composite.order.OrderAggregate;
import com.minimini.api.composite.order.OrderCompositeService;
import com.minimini.api.core.order.Order;
import com.minimini.api.core.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequiredArgsConstructor
public class OrderCompositeServiceImpl implements OrderCompositeService {
    private final StreamBridge streamBridge;

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
}
