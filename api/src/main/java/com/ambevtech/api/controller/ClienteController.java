package com.ambevtech.api.controller;

import com.ambevtech.api.entity.Cliente;
import com.ambevtech.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.deletarPorId(id);
        return "Cliente removido com sucesso!";
    }
}