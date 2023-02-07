package com.minimini.userservice;

import com.minimini.api.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl implements UserService {
    @Override
    public String test() {
        return "hello!!!";
    }
}
