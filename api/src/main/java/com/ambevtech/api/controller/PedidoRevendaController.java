package com.ambevtech.api.controller;

import com.ambevtech.api.entity.PedidoRevenda;
import com.ambevtech.api.service.PedidoRevendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos-revenda")
public class PedidoRevendaController {

    @Autowired
    private PedidoRevendaService pedidoRevendaService;

    @PostMapping
    public PedidoRevenda criar(@RequestBody PedidoRevenda pedidoRevenda) {
        return pedidoRevendaService.salvar(pedidoRevenda);
    }

    @GetMapping
    public List<PedidoRevenda> listarTodos() {
        return pedidoRevendaService.listarTodos();
    }

    @GetMapping("/{id}")
    public PedidoRevenda buscarPorId(@PathVariable Long id) {
        return pedidoRevendaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        pedidoRevendaService.deletarPorId(id);
        return "Pedido da revenda removido com sucesso!";
    }
}