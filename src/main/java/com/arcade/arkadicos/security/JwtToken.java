package com.arcade.arkadicos.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JwtToken implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final long tokenValidity = 18000L;

    @Value("${jwt.secret}")
    private String secret;

    public <T> T getClaim(String token, Function<Claims, T> resolver)
    {
        return resolver.apply(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody());
    }

    public String generateToken(UserDetails details)
    {
        return Jwts.builder().setClaims(new HashMap<String, Object>()).setSubject(details.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + tokenValidity * 1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public boolean validateToken(String token, UserDetails details)
    {
        return getClaim(token, Claims::getSubject).equals(details.getUsername()) && !getClaim(token, Claims::getExpiration).before(new Date());
    }
}