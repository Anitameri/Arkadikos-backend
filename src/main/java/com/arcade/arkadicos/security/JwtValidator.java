package com.arcade.arkadicos.security;

import com.arcade.arkadicos.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtValidator extends OncePerRequestFilter
{
    @Autowired
    private JwtToken token;

    @Autowired
    private UserService service;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        try
        {
            String jwt = null, header = request.getHeader("Authorization");
            if(header != null)
                if(header.startsWith("Bearer "))
                    jwt = header.substring(7, header.length());
            if(jwt != null)
                if(token.validateToken(jwt))
                {
                    UserDetails user = service.loadUserByUsername(token.getUsernameFromToken(jwt));
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
        }
        catch (Exception e)
        {
            System.out.println("Cannot set user authentication!");
        }
        filterChain.doFilter(request, response);
    }
}