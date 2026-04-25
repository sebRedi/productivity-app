package com.productivity.app.domain.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.productivity.app.domain.exception.DomainException;
import com.productivity.app.domain.model.valueobject.EstadoRecordatorio;
import com.productivity.app.domain.model.valueobject.TipoNotificacion;

public class Recordatorio {

    private final UUID id;
    private final UUID tareaId;
    private LocalDateTime fechaRecordatorio;
    private TipoNotificacion tipo;
    private EstadoRecordatorio estado;

    private Recordatorio(
            UUID id,
            UUID tareaId,
            LocalDateTime fechaRecordatorio,
            TipoNotificacion tipo,
            EstadoRecordatorio estado
    ) {
        validarTarea(tareaId);
        validarFecha(fechaRecordatorio);

        this.id = id;
        this.tareaId = tareaId;
        this.fechaRecordatorio = fechaRecordatorio;
        this.tipo = tipo;
        this.estado = estado;
    }

    public static Recordatorio crear(UUID tareaId, LocalDateTime fecha, TipoNotificacion tipo) {
        return new Recordatorio(
                UUID.randomUUID(),
                tareaId,
                fecha,
                tipo == null ? TipoNotificacion.IN_APP : tipo,
                EstadoRecordatorio.PROGRAMADO
        );
    }

    public static Recordatorio reconstruir(
            UUID id,
            UUID tareaId,
            LocalDateTime fecha,
            TipoNotificacion tipo,
            EstadoRecordatorio estado
    ) {
        return new Recordatorio(id, tareaId, fecha, tipo, estado);
    }

    public void cancelar() {
        if (this.estado == EstadoRecordatorio.ENVIADO) {
            throw new DomainException("No se puede cancelar un recordatorio ya enviado.");
        }
        this.estado = EstadoRecordatorio.CANCELADO;
    }

    public void marcarEnviado() {
        if (this.estado != EstadoRecordatorio.PROGRAMADO) {
            throw new DomainException("Solo se pueden enviar recordatorios programados.");
        }
        this.estado = EstadoRecordatorio.ENVIADO;
    }

    private void validarTarea(UUID tareaId) {
        if (tareaId == null) {
            throw new DomainException("El recordatorio debe estar asociado a una tarea.");
        }
    }

    private void validarFecha(LocalDateTime fecha) {
        if (fecha == null || fecha.isBefore(LocalDateTime.now())) {
            throw new DomainException("La fecha del recordatorio debe ser futura.");
        }
    }

    public UUID getId() { return id; }
    public UUID getTareaId() { return tareaId; }
    public LocalDateTime getFechaRecordatorio() { return fechaRecordatorio; }
    public TipoNotificacion getTipo() { return tipo; }
    public EstadoRecordatorio getEstado() { return estado; }
}