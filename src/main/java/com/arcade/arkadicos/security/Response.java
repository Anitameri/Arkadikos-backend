package com.arcade.arkadicos.security;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Response
{
    private Token token;

    private String type = "Bearer ";

    private Long id;

    private String username, email;

    private List<String> roles;

    public Response(Token token, Long id, String username, String email, List<String> roles)
    {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}