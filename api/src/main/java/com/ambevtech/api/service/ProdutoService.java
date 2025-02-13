package com.ambevtech.api.service;

import com.ambevtech.api.entity.Produto;
import com.ambevtech.api.exception.MensagemErro;
import com.ambevtech.api.exception.ProdutoNaoEncontradoException;
import com.ambevtech.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Salvar um produto.
     */
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    /**
     * Listar todos os produtos.
     */
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    /**
     * Buscar produto pelo ID. Lança ProdutoNaoEncontradoException caso não exista.
     */
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(MensagemErro.PRODUTO_NAO_ENCONTRADO.getMensagem()));
    }

    /**
     * Deletar um produto pelo ID.
     */
    public void deletarPorId(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ProdutoNaoEncontradoException(MensagemErro.PRODUTO_NAO_ENCONTRADO.getMensagem());
        }
        produtoRepository.deleteById(id);
    }
}