package com.ambevtech.api.service;

import com.ambevtech.api.controller.JwtProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private final SecretKey secretKey;
    private final long expiration;

    public JwtService(JwtProperties properties) {
        this.expiration = properties.getExpiration();
        this.secretKey = new SecretKeySpec(properties.getSecret().getBytes(), SignatureAlgorithm.HS512.getJcaName());
    }

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey)
                .compact();
    }
}