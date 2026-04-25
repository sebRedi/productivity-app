package com.productivity.app.infrastructure.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.productivity.app.domain.model.valueobject.EstadoTarea;
import com.productivity.app.domain.model.valueobject.Prioridad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tareas")
public class TareaJpaEntity {

    @Id
    private UUID id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(length = 500)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoTarea estado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridad prioridad;

    private LocalDate fechaLimite;

    @Column(nullable = false)
    private UUID usuarioId;

    private UUID proyectoId;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    public TareaJpaEntity() {
    }

    public TareaJpaEntity(
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