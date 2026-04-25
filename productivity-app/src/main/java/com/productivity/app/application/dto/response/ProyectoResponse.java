package com.productivity.app.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.productivity.app.domain.model.valueobject.EstadoProyecto;

public record ProyectoResponse(
        UUID id,
        String nombre,
        String descripcion,
        UUID usuarioId,
        EstadoProyecto estado,
        LocalDateTime fechaCreacion
) {
}