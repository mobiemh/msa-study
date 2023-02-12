package com.minimini.ordercompositeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.minimini")
public class OrderCompositeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderCompositeServiceApplication.class, args);
    }

}
