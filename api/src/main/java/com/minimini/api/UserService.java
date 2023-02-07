package com.minimini.api;

import org.springframework.web.bind.annotation.GetMapping;

public interface UserService {
    @GetMapping(
            value    = "/test")
    String test();
}
