package com.ambevtech.api.service;

import com.ambevtech.api.entity.Cliente;
import com.ambevtech.api.exception.ClienteNaoEncontradoException;
import com.ambevtech.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
            .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado!"));
    }

    public void deletarPorId(Long id) {
        clienteRepository.deleteById(id);
    }

}