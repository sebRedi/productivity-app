package com.productivity.app.application.dto.request;

import java.time.LocalDate;

public record ActualizarTareaRequest(
        String titulo,
        String descripcion,
        LocalDate fechaLimite
) {
}