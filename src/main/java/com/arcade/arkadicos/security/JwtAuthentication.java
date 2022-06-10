package com.arcade.arkadicos.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthentication
{
    private AuthenticationManager auth;

    public JwtAuthentication(AuthenticationManager auth)
    {
        this.auth = auth;
    }


}