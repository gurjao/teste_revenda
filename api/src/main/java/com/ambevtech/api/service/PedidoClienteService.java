package com.ambevtech.api.service;

import com.ambevtech.api.entity.PedidoCliente;
import com.ambevtech.api.exception.MensagemErro;
import com.ambevtech.api.exception.PedidoClienteNaoEncontradoException;
import com.ambevtech.api.repository.PedidoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoClienteService {

    @Autowired
    private PedidoClienteRepository pedidoClienteRepository;

    /**
     * Salvar um pedido do cliente.
     */
    public PedidoCliente salvar(PedidoCliente pedidoCliente) {
        return pedidoClienteRepository.save(pedidoCliente);
    }

    /**
     * Listar todos os pedidos de clientes.
     */
    public List<PedidoCliente> listarTodos() {
        return pedidoClienteRepository.findAll();
    }

    /**
     * Buscar pedido do cliente pelo ID. Lança PedidoClienteNaoEncontradoException caso não exista.
     */
    public PedidoCliente buscarPorId(Long id) {
        return pedidoClienteRepository.findById(id)
                .orElseThrow(() -> new PedidoClienteNaoEncontradoException(MensagemErro.PEDIDO_CLIENTE_NAO_ENCONTRADO.getMensagem()));
    }

    /**
     * Deletar pedido do cliente pelo ID.
     */
    public void deletarPorId(Long id) {
        if (!pedidoClienteRepository.existsById(id)) {
            throw new PedidoClienteNaoEncontradoException(MensagemErro.PEDIDO_CLIENTE_NAO_ENCONTRADO.getMensagem());
        }
        pedidoClienteRepository.deleteById(id);
    }
}