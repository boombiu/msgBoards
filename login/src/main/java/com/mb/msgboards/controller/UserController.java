package com.mb.msgboards.controller;

import com.mb.msgboards.model.ResultCode;
import com.mb.msgboards.model.User;
import com.mb.msgboards.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultCode login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/registry")
    public ResultCode registry(@RequestBody User user) {
        return userService.registry(user);
    }
}
