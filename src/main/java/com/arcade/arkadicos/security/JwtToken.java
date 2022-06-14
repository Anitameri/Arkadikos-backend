package com.arcade.arkadicos.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JwtToken implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Value("${jwt.validation}")
    private long validation;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(Authentication auth)
    {
        return Jwts.builder().setClaims(new HashMap<String, Object>()).setSubject(((UserDetails)auth.getPrincipal()).getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + validation)).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getUsernameFromToken(String token)
    {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token)
    {
        try
        {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }
        catch(Exception e)
        {
            System.out.println("Invalid JWT token!");
        }
        return false;
    }
}