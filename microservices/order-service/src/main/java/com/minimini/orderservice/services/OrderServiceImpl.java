package com.minimini.orderservice.services;

import com.minimini.api.core.order.Order;
import com.minimini.api.core.order.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class OrderServiceImpl implements OrderService {

    @Override
    public void createOrder(Order order) {
        System.out.println("####### created new order #######" + order);
    }

    @Retry(name = "getOrder")
    @CircuitBreaker(name = "getOrder")
    @Override
    public Mono<Order> getOrder(int orderId) {
        return Mono.just(new Order()).map(order1 -> {
            order1.setOrderId(orderId);
            return order1;
        });
    }
}
