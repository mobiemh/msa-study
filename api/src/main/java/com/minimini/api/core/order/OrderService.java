package com.minimini.api.core.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public interface OrderService {
    void createOrder(@RequestBody Order order);

    @GetMapping("/order/{orderId}")
    Mono<Order> getOrder(@PathVariable int orderId);
}
