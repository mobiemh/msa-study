package com.minimini.api.core.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
