package com.productivity.app.domain.model.valueobject;

import java.util.regex.Pattern;

import com.productivity.app.domain.exception.DomainException;

public class Correo {

    private final String valor;

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public Correo(String valor) {
        if (valor == null || valor.isBlank()) {
            throw new DomainException("El correo es obligatorio.");
        }

        if (!EMAIL_PATTERN.matcher(valor).matches()) {
            throw new DomainException("El formato del correo es inválido.");
        }

        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}