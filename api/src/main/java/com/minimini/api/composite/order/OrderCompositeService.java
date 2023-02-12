package com.minimini.api.composite.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface OrderCompositeService {
    @PostMapping("/order")
    void createOrderAggregate(@RequestBody OrderAggregate orderAggregate);
}
