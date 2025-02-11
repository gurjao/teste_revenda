package com.ambevtech.api.service;

import com.ambevtech.api.entity.PedidoRevenda;
import com.ambevtech.api.exception.PedidoRevendaNaoEncontradoException;
import com.ambevtech.api.repository.PedidoRevendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoRevendaService {
    @Autowired
    private PedidoRevendaRepository pedidoRevendaRepository;

    public PedidoRevenda salvar(PedidoRevenda pedidoRevenda) {
        return pedidoRevendaRepository.save(pedidoRevenda);
    }

    public List<PedidoRevenda> listarTodos() {
        return pedidoRevendaRepository.findAll();
    }

    public PedidoRevenda buscarPorId(Long id) {
        return pedidoRevendaRepository.findById(id)
            .orElseThrow(() -> new PedidoRevendaNaoEncontradoException("Pedido da revenda não encontrado!"));
    }

    public void deletarPorId(Long id) {
        pedidoRevendaRepository.deleteById(id);
    }
}