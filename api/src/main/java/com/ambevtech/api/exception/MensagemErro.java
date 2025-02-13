package com.ambevtech.api.exception;

public enum MensagemErro {
    CLIENTE_NAO_ENCONTRADO("Cliente não encontrado"),
    PRODUTO_NAO_ENCONTRADO("Produto não encontrado"),
    PEDIDO_CLIENTE_NAO_ENCONTRADO("Pedido do cliente não encontrado"),
    PEDIDO_REVENDA_NAO_ENCONTRADO("Pedido de revenda não encontrado"),
    REVENDA_NAO_ENCONTRADA("Revenda não encontrada");

    private final String mensagem;

    MensagemErro(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}