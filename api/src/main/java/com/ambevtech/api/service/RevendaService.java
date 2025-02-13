package com.ambevtech.api.service;

import com.ambevtech.api.entity.Revenda;
import com.ambevtech.api.exception.MensagemErro;
import com.ambevtech.api.exception.RevendaNaoEncontradoException;
import com.ambevtech.api.repository.RevendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevendaService {

    @Autowired
    private RevendaRepository revendaRepository;

    /**
     * Salvar uma revenda.
     */
    public Revenda salvar(Revenda revenda) {
        return revendaRepository.save(revenda);
    }

    /**
     * Listar todas as revendas.
     */
    public List<Revenda> listarTodos() {
        return revendaRepository.findAll();
    }

    /**
     * Buscar revenda pelo ID. Lança RevendaNaoEncontradoException caso não exista.
     */
    public Revenda buscarPorId(Long id) {
        return revendaRepository.findById(id)
                .orElseThrow(() -> new RevendaNaoEncontradoException(MensagemErro.REVENDA_NAO_ENCONTRADA.getMensagem()));
    }

    /**
     * Deletar uma revenda pelo ID.
     */
    public void deletarPorId(Long id) {
        if (!revendaRepository.existsById(id)) {
            throw new RevendaNaoEncontradoException(MensagemErro.REVENDA_NAO_ENCONTRADA.getMensagem());
        }
        revendaRepository.deleteById(id);
    }
}