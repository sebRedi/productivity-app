package com.productivity.app.application.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import com.productivity.app.domain.model.valueobject.Prioridad;

public record CrearTareaRequest(
        String titulo,
        String descripcion,
        Prioridad prioridad,
        LocalDate fechaLimite,
        UUID usuarioId,
        UUID proyectoId
) {
}