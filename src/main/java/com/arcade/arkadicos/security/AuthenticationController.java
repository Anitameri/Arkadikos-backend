package com.arcade.arkadicos.security;

import com.arcade.arkadicos.users.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8080")
public class AuthenticationController
{
    private final AuthenticationManagerBuilder auth;

    private final JwtToken token;

    public AuthenticationController(JwtToken token, AuthenticationManagerBuilder auth)
    {
        this.token = token;
        this.auth = auth;
    }

    @PostMapping("/api/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody Login user)
    {
        Authentication aut = auth.getObject().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(aut);
        User s = (User) aut.getPrincipal();
        return ResponseEntity.ok(new Response(token.generateToken(aut), s.getId(), s.getUsername(), s.getEmail(), s.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList())));
    }
}