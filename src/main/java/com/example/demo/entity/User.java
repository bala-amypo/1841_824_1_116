package com.example.demo.entity;



import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;
@Entity
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(unique=true)
    private String email;
    private String password;

@Column(name = "role")
private Set<String> roles;

    private LocalDateTime createdAt;

    public User()
    {}
    public User(
    String email,
    String password,
    Set<String> roles)
    {
        this.email=email;
        this.password=password;
        this.roles=roles;
        this.createdAt = LocalDateTime.now();
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}


