package com.productivity.app.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.productivity.app.domain.model.valueobject.EstadoProyecto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyectos")
public class ProyectoJpaEntity {

    @Id
    private UUID id;

    @Column(nullable = false, length = 120)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false)
    private UUID usuarioId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoProyecto estado;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    public ProyectoJpaEntity() {
    }

    public ProyectoJpaEntity(
            UUID id,
            String nombre,
            String descripcion,
            UUID usuarioId,
            EstadoProyecto estado,
            LocalDateTime fechaCreacion
    ) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuarioId = usuarioId;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
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