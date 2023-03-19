package com.minimini.api.core.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public interface UserService {
    String login();

    @GetMapping("/user/{uid}")
    Mono<User> getUser(@PathVariable String uid);
}
