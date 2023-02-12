package com.minimini.orderservice.services;

import com.minimini.api.composite.order.OrderAggregate;
import com.minimini.api.core.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class ConsumerProcessor {
    private final OrderService orderService;

    @Bean
    public Consumer<Integer> test() {
        System.out.println("receive!!");
        return msg -> {
            //orderService.createOrder(msg.getPayload().getOrder());
        };
    }

    @Bean
    public Consumer<Message<OrderAggregate>> createOrder() {
        System.out.println("order receive!!");
        return msg -> {
            System.out.println("order receive!!" + msg.getPayload().getOrder().getTitle());
            //orderService.createOrder(msg.getPayload().getOrder());
        };
    }
}
