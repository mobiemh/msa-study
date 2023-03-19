package com.minimini.api.core.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
    private String uid;
    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return this.name;
    }
}
