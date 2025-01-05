package com.example.expense_tracker.Config;

import java.io.IOException;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.expense_tracker.Service.JWTService;
import com.example.expense_tracker.Service.UserServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter  {

    // @Autowired
    // private JWTService jwtService;

    // @Autowired
    // private ApplicationContext context;

    // @Override
    // protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    //         throws ServletException, IOException {
    //          String authHead = request.getHeader("Autherization");
    //          String token = null;
    //          String username = null;
    //          if(authHead!= null && authHead.startsWith("Bearer ")) {
    //             token = authHead.substring(7);
    //             username = jwtService.extractUserName(token);
    //          }

    //          if(username != null && SecurityContextHolder.getContext().getAuthentication()==null) {

    //             UserDetails userDetails = context.getBean(UserServiceImpl.class).getBy
    //             if(jwtService.validateToken(token,userDetails)) {

    //             }
    //          }
    //             throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
    // }
    

}
