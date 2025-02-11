package com.ambevtech.api.service;

import com.ambevtech.api.entity.PedidoCliente;
import com.ambevtech.api.exception.PedidoClienteNaoEncontradoException;
import com.ambevtech.api.repository.PedidoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoClienteService {
    @Autowired
    private PedidoClienteRepository pedidoClienteRepository;

    public PedidoCliente salvar(PedidoCliente pedidoCliente) {
        return pedidoClienteRepository.save(pedidoCliente);
    }

    public List<PedidoCliente> listarTodos() {
        return pedidoClienteRepository.findAll();
    }

    public PedidoCliente buscarPorId(Long id) {
        return pedidoClienteRepository.findById(id)
            .orElseThrow(() -> new PedidoClienteNaoEncontradoException("ClientePedido não encontrado!"));
    }

    public void deletarPorId(Long id) {
        pedidoClienteRepository.deleteById(id);
    }
}