package com.ambevtech.api.exception;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}