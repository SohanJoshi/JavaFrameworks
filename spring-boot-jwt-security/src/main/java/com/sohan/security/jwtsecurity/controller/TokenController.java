package com.sohan.security.jwtsecurity.controller;

import com.sohan.security.jwtsecurity.model.JwtUser;
import com.sohan.security.jwtsecurity.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private JwtGenerator tokenGenerator;

    @PostMapping
    public String generateToken(@RequestBody JwtUser jwtUser) {
        return tokenGenerator.generate(jwtUser);
    }
}
