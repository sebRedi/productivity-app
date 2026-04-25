package com.productivity.app.application.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.productivity.app.domain.model.valueobject.EstadoTarea;
import com.productivity.app.domain.model.valueobject.Prioridad;

public record TareaResponse(
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
}