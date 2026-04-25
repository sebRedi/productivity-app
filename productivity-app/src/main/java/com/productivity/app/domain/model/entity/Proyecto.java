package com.productivity.app.domain.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.productivity.app.domain.exception.DomainException;
import com.productivity.app.domain.model.valueobject.EstadoProyecto;

public class Proyecto {

    private final UUID id;
    private String nombre;
    private String descripcion;
    private final UUID usuarioId;
    private EstadoProyecto estado;
    private final LocalDateTime fechaCreacion;

    private Proyecto(
            UUID id,
            String nombre,
            String descripcion,
            UUID usuarioId,
            EstadoProyecto estado,
            LocalDateTime fechaCreacion
    ) {
        validarNombre(nombre);
        validarUsuario(usuarioId);

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuarioId = usuarioId;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public static Proyecto crear(String nombre, String descripcion, UUID usuarioId) {
        return new Proyecto(
                UUID.randomUUID(),
                nombre,
                descripcion,
                usuarioId,
                EstadoProyecto.ACTIVO,
                LocalDateTime.now()
        );
    }

    public static Proyecto reconstruir(
            UUID id,
            String nombre,
            String descripcion,
            UUID usuarioId,
            EstadoProyecto estado,
            LocalDateTime fechaCreacion
    ) {
        return new Proyecto(id, nombre, descripcion, usuarioId, estado, fechaCreacion);
    }

    public void actualizar(String nombre, String descripcion) {
        validarNombre(nombre);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void archivar() {
        if (this.estado == EstadoProyecto.COMPLETADO) {
            throw new DomainException("No se puede archivar un proyecto completado.");
        }

        this.estado = EstadoProyecto.ARCHIVADO;
    }

    public void completar() {
        if (this.estado == EstadoProyecto.ARCHIVADO) {
            throw new DomainException("No se puede completar un proyecto archivado.");
        }

        this.estado = EstadoProyecto.COMPLETADO;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new DomainException("El nombre del proyecto es obligatorio.");
        }

        if (nombre.length() > 120) {
            throw new DomainException("El nombre del proyecto no puede superar 120 caracteres.");
        }
    }

    private void validarUsuario(UUID usuarioId) {
        if (usuarioId == null) {
            throw new DomainException("El proyecto debe pertenecer a un usuario.");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public EstadoProyecto getEstado() {
        return estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}