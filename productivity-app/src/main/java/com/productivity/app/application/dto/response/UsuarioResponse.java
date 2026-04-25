package com.productivity.app.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record UsuarioResponse(
        UUID id,
        String nombre,
        String correo,
        LocalDateTime fechaRegistro
) {}