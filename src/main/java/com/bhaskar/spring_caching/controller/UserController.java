package com.bhaskar.spring_caching.controller;

import com.bhaskar.spring_caching.service.MyUserDetailService;
import com.bhaskar.spring_caching.webtoken.JwtService;
import com.bhaskar.spring_caching.webtoken.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @GetMapping("/home")
    public String handleWelcome() {
        return "wel come to home";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome() {
        return "wel come to ADMIN curityCoHome";
    }

    @GetMapping("/user/home")
    public String handleUserHome() {
        return "welcome to User Home";
    }


    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {

        log.info("Started >>>");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.username(), loginForm.password()
        ));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(myUserDetailService.loadUserByUsername(loginForm.username()));
        } else {
            log.info("please try again");
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }
}


