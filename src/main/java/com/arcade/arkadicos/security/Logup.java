package com.arcade.arkadicos.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Logup
{
    private String username, email;

    private Set<String> role;

    private String password;
}