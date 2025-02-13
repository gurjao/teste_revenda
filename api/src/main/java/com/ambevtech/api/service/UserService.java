package com.ambevtech.api.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean authenticate(String username, String password) {
        // Para fins de exemplo, simula um banco de dados
        // No futuro, isso poderia ser substituído por um repositório real.
        return "admin".equals(username) && "password".equals(password);
    }
}