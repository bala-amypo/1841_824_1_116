package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userSerObj;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userSerObj.registerUser(user.getEmail(), user.getPassword());
    }

    @PostMapping("/login")
    public User login(@RequestParam String email) {
        return userSerObj.getUserByEmail(email);
    }
}
