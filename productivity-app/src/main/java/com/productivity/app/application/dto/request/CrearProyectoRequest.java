package com.productivity.app.application.dto.request;

import java.util.UUID;

public record CrearProyectoRequest(
        String nombre,
        String descripcion,
        UUID usuarioId
) {
}