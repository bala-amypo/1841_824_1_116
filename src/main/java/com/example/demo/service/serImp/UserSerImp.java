package com.example.demo.service.serImp;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import java.util.Set;

public class UserSerImp implements UserService {

    private final UserRepository userRepository;

    public UserSerImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(String email, String password) {

        User user = new User();   // ✅ NO builder
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of("USER"));

        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with email: " + email));
    }
}
