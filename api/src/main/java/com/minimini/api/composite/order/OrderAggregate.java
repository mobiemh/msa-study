package com.minimini.api.composite.order;

import com.minimini.api.core.order.Order;
import com.minimini.api.core.user.User;

public class OrderAggregate {
    public Order order;
    public User user;

    public OrderAggregate(Order order, User user) {
        this.order = order;
        this.user = user;
    }
    public Order getOrder() {
        return this.order;
    }
    public User getUser() {
        return this.user;
    }
}
