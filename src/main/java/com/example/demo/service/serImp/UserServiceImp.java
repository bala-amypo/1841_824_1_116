package com.example.demo.service;
import com.example.demo.entity.User;

public interface  UserService { 
    public void registerUser(String email,String password);
    User getUserByEmail(String email);
}
