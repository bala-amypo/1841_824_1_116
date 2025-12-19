package com.example.demo.service.serImp;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserSerImp implements UserService{
    
    @Autowired
    UserRepository userRepoObj;

    @Override
    public void registerUser(String email,String password)
    {
        User user=new User(email,password, Set.of("USER"));
        userRepoObj.save(user);
    }

    @Override
    public User getUserByEmail(String email)
    {
        return userRepoObj.findByEmail(email);
    }
}
