package com.productivity.app.domain.exception;

public class TareaNoEncontradaException extends DomainException {

    public TareaNoEncontradaException() {
        super("La tarea solicitada no existe.");
    }
}