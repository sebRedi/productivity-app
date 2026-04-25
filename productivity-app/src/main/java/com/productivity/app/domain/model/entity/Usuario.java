package com.productivity.app.domain.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.productivity.app.domain.exception.DomainException;
import com.productivity.app.domain.model.valueobject.Correo;

public class Usuario {

    private final UUID id;
    private String nombre;
    private Correo correo;
    private final LocalDateTime fechaRegistro;

    private Usuario(UUID id, String nombre, Correo correo, LocalDateTime fechaRegistro) {
        validarNombre(nombre);

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    public static Usuario crear(String nombre, String correo) {
        return new Usuario(
                UUID.randomUUID(),
                nombre,
                new Correo(correo),
                LocalDateTime.now()
        );
    }

    public static Usuario reconstruir(UUID id, String nombre, String correo, LocalDateTime fechaRegistro) {
        return new Usuario(
                id,
                nombre,
                new Correo(correo),
                fechaRegistro
        );
    }

    public void actualizarNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new DomainException("El nombre es obligatorio.");
        }
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public Correo getCorreo() { return correo; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
}