package com.ambevtech.api.exception;

public class RevendaNaoEncontradoException extends RuntimeException {
    public RevendaNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}