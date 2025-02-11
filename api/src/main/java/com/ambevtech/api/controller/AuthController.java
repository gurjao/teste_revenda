package com.ambevtech.api.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Date;

import static javax.crypto.Cipher.SECRET_KEY;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "password".equals(password)) {
            return Jwts.builder()
                    .setSubject(username)
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                    .signWith(SECRET_KEY)
                    .compact();
        }
        throw new RuntimeException("Credenciais inválidas");
    }
}