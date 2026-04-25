package com.productivity.app.domain.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.productivity.app.domain.exception.DomainException;
import com.productivity.app.domain.model.valueobject.EstadoTarea;
import com.productivity.app.domain.model.valueobject.Prioridad;

public class Tarea {

    private final UUID id;
    private String titulo;
    private String descripcion;
    private EstadoTarea estado;
    private Prioridad prioridad;
    private LocalDate fechaLimite;
    private final UUID usuarioId;
    private UUID proyectoId;
    private final LocalDateTime fechaCreacion;

    private Tarea(
            UUID id,
            String titulo,
            String descripcion,
            EstadoTarea estado,
            Prioridad prioridad,
            LocalDate fechaLimite,
            UUID usuarioId,
            UUID proyectoId,
            LocalDateTime fechaCreacion
    ) {
        validarTitulo(titulo);
        validarUsuario(usuarioId);
        validarFechaLimite(fechaLimite);

        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
        this.usuarioId = usuarioId;
        this.proyectoId = proyectoId;
        this.fechaCreacion = fechaCreacion;
    }

    public static Tarea crear(
            String titulo,
            String descripcion,
            Prioridad prioridad,
            LocalDate fechaLimite,
            UUID usuarioId,
            UUID proyectoId
    ) {
        return new Tarea(
                UUID.randomUUID(),
                titulo,
                descripcion,
                EstadoTarea.PENDIENTE,
                prioridad == null ? Prioridad.MEDIA : prioridad,
                fechaLimite,
                usuarioId,
                proyectoId,
                LocalDateTime.now()
        );
    }

    public static Tarea reconstruir(
        UUID id,
        String titulo,
        String descripcion,
        EstadoTarea estado,
        Prioridad prioridad,
        LocalDate fechaLimite,
        UUID usuarioId,
        UUID proyectoId,
        LocalDateTime fechaCreacion
    ) {
        return new Tarea(
            id,
            titulo,
            descripcion,
            estado,
            prioridad,
            fechaLimite,
            usuarioId,
            proyectoId,
            fechaCreacion
        ); 
    }

    public void completar() {
        if (this.estado == EstadoTarea.CANCELADA) {
            throw new DomainException("No se puede completar una tarea cancelada.");
        }

        this.estado = EstadoTarea.COMPLETADA;
    }

    public void cancelar() {
        if (this.estado == EstadoTarea.COMPLETADA) {
            throw new DomainException("No se puede cancelar una tarea completada.");
        }

        this.estado = EstadoTarea.CANCELADA;
    }

    public void reabrir() {
        if (this.estado != EstadoTarea.COMPLETADA && this.estado != EstadoTarea.CANCELADA) {
            throw new DomainException("Solo se pueden reabrir tareas completadas o canceladas.");
        }

        this.estado = EstadoTarea.PENDIENTE;
    }

    public void cambiarEstado(EstadoTarea nuevoEstado) {
        if (nuevoEstado == null) {
            throw new DomainException("El estado de la tarea es obligatorio.");
        }

        if (this.estado == EstadoTarea.CANCELADA && nuevoEstado == EstadoTarea.COMPLETADA) {
            throw new DomainException("No se puede completar una tarea cancelada.");
        }

        this.estado = nuevoEstado;
    }

    public void cambiarPrioridad(Prioridad nuevaPrioridad) {
        if (nuevaPrioridad == null) {
            throw new DomainException("La prioridad de la tarea es obligatoria.");
        }

        this.prioridad = nuevaPrioridad;
    }

    public void actualizarInformacion(String titulo, String descripcion, LocalDate fechaLimite) {
        validarTitulo(titulo);
        validarFechaLimite(fechaLimite);

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
    }

    public void asignarAProyecto(UUID proyectoId) {
        if (proyectoId == null) {
            throw new DomainException("El proyecto es obligatorio para asignar la tarea.");
        }

        this.proyectoId = proyectoId;
    }

    private void validarTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new DomainException("El título de la tarea es obligatorio.");
        }

        if (titulo.length() > 120) {
            throw new DomainException("El título de la tarea no puede superar 120 caracteres.");
        }
    }

    private void validarUsuario(UUID usuarioId) {
        if (usuarioId == null) {
            throw new DomainException("La tarea debe pertenecer a un usuario.");
        }
    }

    private void validarFechaLimite(LocalDate fechaLimite) {
        if (fechaLimite != null && fechaLimite.isBefore(LocalDate.now())) {
            throw new DomainException("La fecha límite no puede estar en el pasado.");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public UUID getProyectoId() {
        return proyectoId;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}