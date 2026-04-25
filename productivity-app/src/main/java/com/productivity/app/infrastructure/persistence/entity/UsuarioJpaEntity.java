package com.productivity.app.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioJpaEntity {

    @Id
    private UUID id;

    private String nombre;

    @Column(unique = true)
    private String correo;

    private LocalDateTime fechaRegistro;

    public UsuarioJpaEntity() {}

    public UsuarioJpaEntity(UUID id, String nombre, String correo, LocalDateTime fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
}