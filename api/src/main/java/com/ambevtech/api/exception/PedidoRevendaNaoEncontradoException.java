package com.ambevtech.api.exception;

public class PedidoRevendaNaoEncontradoException extends RuntimeException {
    public PedidoRevendaNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}