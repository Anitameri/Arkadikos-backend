package com.arcade.arkadicos.security;

import com.arcade.arkadicos.users.User;
import com.arcade.arkadicos.users.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AuthenticationController
{
    private final AuthenticationManagerBuilder auth;

    private final JwtToken token;

    private final UserDetailsService service;

    public AuthenticationController(JwtToken token, UserDetailsService service, AuthenticationManagerBuilder auth)
    {
        this.token = token;
        this.service = service;
        this.auth = auth;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody Login user)
    {
        Authentication aut = auth.getObject().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(aut);
        User s = (User) aut.getPrincipal();
        return ResponseEntity.ok(new Response(token.generateToken(aut), s.getId(), s.getUsername(), s.getEmail(), s.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList())));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody Logup user)
    {
        //if user exists
        //return ResponseEntity.badRequest().body(new Message("The user with name " + user.getUsername() + " already exists"));

        //same with email

        //save the user

        return ResponseEntity.ok(new Message("User registered"));
    }
}