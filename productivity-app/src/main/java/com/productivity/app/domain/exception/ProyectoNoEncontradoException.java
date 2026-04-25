package com.productivity.app.domain.exception;

public class ProyectoNoEncontradoException extends DomainException {

    public ProyectoNoEncontradoException() {
        super("El proyecto solicitado no existe.");
    }
}