package com.minimini.userservice;

import com.minimini.api.core.user.User;
import com.minimini.api.core.user.UserService;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserServiceImpl implements UserService {
    @Override
    public String login() {
        return "hello!!!";
    }

    @Override
    public Mono<User> getUser(String uid) {
        return Mono.just(new User()).map(user1 -> {
            user1.setUid(uid);
            return user1;
        });
    }
}
