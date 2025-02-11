package com.ambevtech.api.service;

import com.ambevtech.api.entity.Revenda;
import com.ambevtech.api.exception.RevendaNaoEncontradoException;
import com.ambevtech.api.repository.RevendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevendaService {
    @Autowired
    private RevendaRepository revendaRepository;

    public Revenda salvar(Revenda revenda) {
        return revendaRepository.save(revenda);
    }

    public List<Revenda> listarTodos() {
        return revendaRepository.findAll();
    }

    public Revenda buscarPorId(Long id) {
        return revendaRepository.findById(id)
                .orElseThrow(() -> new RevendaNaoEncontradoException("Revenda com ID " + id + " não encontrada!"));
    }

    public void deletarPorId(Long id) {
        revendaRepository.deleteById(id);
    }
}