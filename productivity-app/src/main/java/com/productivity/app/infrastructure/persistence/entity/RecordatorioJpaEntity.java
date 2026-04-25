package com.productivity.app.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.productivity.app.domain.model.valueobject.EstadoRecordatorio;
import com.productivity.app.domain.model.valueobject.TipoNotificacion;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recordatorios")
public class RecordatorioJpaEntity {

    @Id
    private UUID id;

    private UUID tareaId;

    private LocalDateTime fechaRecordatorio;

    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipo;

    @Enumerated(EnumType.STRING)
    private EstadoRecordatorio estado;

    public RecordatorioJpaEntity() {}

    public RecordatorioJpaEntity(UUID id, UUID tareaId, LocalDateTime fechaRecordatorio,
                                 TipoNotificacion tipo, EstadoRecordatorio estado) {
        this.id = id;
        this.tareaId = tareaId;
        this.fechaRecordatorio = fechaRecordatorio;
        this.tipo = tipo;
        this.estado = estado;
    }

    public UUID getId() { return id; }
    public UUID getTareaId() { return tareaId; }
    public LocalDateTime getFechaRecordatorio() { return fechaRecordatorio; }
    public TipoNotificacion getTipo() { return tipo; }
    public EstadoRecordatorio getEstado() { return estado; }
}