// package com.example.demo.service.serImp;
// import java.util.Set;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;

// @Service
// public class UserSerImp implements UserService{
    
//     @Autowired
//     UserRepository userRepoObj;

//     @Override
//     public void registerUser(String email,String password)
//     {
//         User user=new User(email,password, Set.of("USER"));
//         userRepoObj.save(user);
//     }

//     @Override
//     public User getUserByEmail(String email)
//     {
//         return userRepoObj.findByEmail(email);
//     }
// }
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

    // ✅ REQUIRED by UserService interface
    @Override
    public void registerUser(String email, String password) {

        User user = User.builder()
                .email(email)
                .password(password)
                .roles(Set.of("USER"))
                .build();

        userRepository.save(user);
    }

    // ✅ REQUIRED by UserService interface
    @Override
    public User getUserByEmail(String email) {

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with email: " + email));
    }
}
