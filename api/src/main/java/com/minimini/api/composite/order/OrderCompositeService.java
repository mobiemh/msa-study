package com.minimini.api.composite.order;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public interface OrderCompositeService {
    @PostMapping("/order-composite")
    void createOrderAggregate(@RequestBody OrderAggregate orderAggregate);

    @GetMapping("/order-composite/{orderId}")
    Mono<OrderAggregate> getOrderAggregate(@PathVariable int orderId);
}
