package com.ambevtech.api.exception;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String mensagem) {
        super(mensagem);
    }
}