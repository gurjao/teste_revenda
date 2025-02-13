package com.ambevtech.api.controller;

import com.ambevtech.api.service.JwtService;
import com.ambevtech.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        log.info("Tentativa de login para o usuário: {}", username);
        if (userService.authenticate(username, password)) {
            String token = jwtService.generateToken(username);
            log.info("Login realizado com sucesso para o usuário: {}", username);
            return Map.of("username", username, "token", token).toString();
        }
        log.warn("Falha no login para o usuário: {}", username);
        throw new RuntimeException("Credenciais inválidas");
    }
}
