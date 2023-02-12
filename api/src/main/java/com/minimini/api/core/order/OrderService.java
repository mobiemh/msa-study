package com.minimini.api.core.order;

import org.springframework.web.bind.annotation.RequestBody;

public interface OrderService {
    void createOrder(@RequestBody Order order);
}
