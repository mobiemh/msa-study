package com.minimini.orderservice.services;

import com.minimini.api.core.order.OrderService;
import com.minimini.api.core.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl implements OrderService {

    @Override
    public void createOrder(Order order) {
        System.out.println("####### created new order #######" + order);
    }
}
