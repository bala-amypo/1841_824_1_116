package com.example.demo.security;

import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.*;

public class CustomUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        var u = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Not found"));
        return User.withUsername(u.getEmail())
                .password(u.getPassword())
                .authorities(u.getRoles().toArray(new String[0]))
                .build();
    }
}
