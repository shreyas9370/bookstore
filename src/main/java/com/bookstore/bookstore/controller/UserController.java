package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.model.User;
import com.bookstore.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return userService.signUp(user);
    }
}
