package com.ambevtech.api.service;

import com.ambevtech.api.entity.Cliente;
import com.ambevtech.api.exception.ClienteNaoEncontradoException;
import com.ambevtech.api.exception.MensagemErro;
import com.ambevtech.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Salvar um cliente.
     */
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Listar todos os clientes.
     */
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    /**
     * Buscar cliente pelo ID. Lança ClienteNaoEncontradoException caso não exista.
     */
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(MensagemErro.CLIENTE_NAO_ENCONTRADO.getMensagem()));
    }

    /**
     * Deletar um cliente pelo ID.
     */
    public void deletarPorId(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ClienteNaoEncontradoException(MensagemErro.CLIENTE_NAO_ENCONTRADO.getMensagem());
        }
        clienteRepository.deleteById(id);
    }
}