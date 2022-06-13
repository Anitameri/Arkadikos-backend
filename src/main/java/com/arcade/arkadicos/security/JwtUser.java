package com.arcade.arkadicos.security;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class JwtUser implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;

    private String username, password;
}