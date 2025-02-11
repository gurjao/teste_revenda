package com.ambevtech.api.exception;

public class PedidoClienteNaoEncontradoException extends RuntimeException {
    public PedidoClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}