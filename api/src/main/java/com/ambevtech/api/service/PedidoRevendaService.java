package com.ambevtech.api.service;

import com.ambevtech.api.entity.PedidoRevenda;
import com.ambevtech.api.exception.MensagemErro;
import com.ambevtech.api.exception.PedidoRevendaNaoEncontradoException;
import com.ambevtech.api.repository.PedidoRevendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoRevendaService {

    @Autowired
    private PedidoRevendaRepository pedidoRevendaRepository;

    /**
     * Salvar um pedido de revenda.
     */
    public PedidoRevenda salvar(PedidoRevenda pedidoRevenda) {
        return pedidoRevendaRepository.save(pedidoRevenda);
    }

    /**
     * Listar todos os pedidos de revenda.
     */
    public List<PedidoRevenda> listarTodos() {
        return pedidoRevendaRepository.findAll();
    }

    /**
     * Buscar pedido de revenda pelo ID. Lança PedidoRevendaNaoEncontradoException caso não exista.
     */
    public PedidoRevenda buscarPorId(Long id) {
        return pedidoRevendaRepository.findById(id)
                .orElseThrow(() -> new PedidoRevendaNaoEncontradoException(MensagemErro.PEDIDO_REVENDA_NAO_ENCONTRADO.getMensagem()));
    }

    /**
     * Deletar pedido de revenda pelo ID.
     */
    public void deletarPorId(Long id) {
        if (!pedidoRevendaRepository.existsById(id)) {
            throw new PedidoRevendaNaoEncontradoException(MensagemErro.PEDIDO_REVENDA_NAO_ENCONTRADO.getMensagem());
        }
        pedidoRevendaRepository.deleteById(id);
    }
}