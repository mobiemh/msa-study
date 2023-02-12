package com.minimini.api.core.order;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private String title;
    private String body;

    public Order() {}

    public Order(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    @Override
    public String toString() {
        return this.title + " " + this.body;
    }
}
