package com.ambevtech.api.controller;

import com.ambevtech.api.entity.PedidoCliente;
import com.ambevtech.api.service.PedidoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos-cliente")
public class PedidoClienteController {

    @Autowired
    private PedidoClienteService pedidoClienteService;

    @PostMapping
    public PedidoCliente criar(@RequestBody PedidoCliente pedidoCliente) {
        return pedidoClienteService.salvar(pedidoCliente);
    }

    @GetMapping
    public List<PedidoCliente> listarTodos() {
        return pedidoClienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public PedidoCliente buscarPorId(@PathVariable Long id) {
        return pedidoClienteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        pedidoClienteService.deletarPorId(id);
        return "Pedido do cliente removido com sucesso!";
    }
}