package com.minimini.userservice;

import com.minimini.api.core.user.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl implements UserService {
    @Override
    public String login() {
        return "hello!!!";
    }
}
