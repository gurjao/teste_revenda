package com.ambevtech.api.controller;

import com.ambevtech.api.entity.Revenda;
import com.ambevtech.api.service.RevendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revendas")
public class RevendaController {

    @Autowired
    private RevendaService revendaService;

    @PostMapping
    public Revenda criar(@RequestBody Revenda revenda) {
        return revendaService.salvar(revenda);
    }

    @GetMapping
    public List<Revenda> listarTodos() {
        return revendaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Revenda buscarPorId(@PathVariable Long id) {
        return revendaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        revendaService.deletarPorId(id);
        return "Revenda removida com sucesso!";
    }
}