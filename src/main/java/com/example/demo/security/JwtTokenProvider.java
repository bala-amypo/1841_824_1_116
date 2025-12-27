package com.example.demo.security;

import java.util.*;

public class JwtTokenProvider {

    // injected via reflection in tests
    String jwtSecret;
    long jwtExpirationMs;

    // Fake token format: userId|email|roles
    public String generateToken(Long userId, String email, Set<String> roles) {
        return userId + "|" + email + "|" + String.join(",", roles);
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("|");
    }

    public Map<String, Object> getClaims(String token) {
        String[] parts = token.split("\\|");

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", parts[0]);
        claims.put("email", parts[1]);
        claims.put("roles", parts.length > 2 ? parts[2] : "");

        return claims;
    }
}
