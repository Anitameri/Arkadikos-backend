package com.arcade.arkadicos.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Token
{
    private Date expiration;

    private String token;
}