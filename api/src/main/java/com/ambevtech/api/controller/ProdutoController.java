package com.ambevtech.api.controller;

import com.ambevtech.api.entity.Produto;
import com.ambevtech.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        produtoService.deletarPorId(id);
        return "Produto removido com sucesso!";
    }
}