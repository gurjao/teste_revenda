package com.ambevtech.api.service;

import com.ambevtech.api.entity.Produto;
import com.ambevtech.api.exception.ProdutoNaoEncontradoException;
import com.ambevtech.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
            .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado!"));
    }

    public void deletarPorId(Long id) {
        produtoRepository.deleteById(id);
    }

}