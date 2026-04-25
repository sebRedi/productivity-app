package com.productivity.app.application.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

import com.productivity.app.domain.model.valueobject.TipoNotificacion;

public record CrearRecordatorioRequest(
        UUID tareaId,
        LocalDateTime fechaRecordatorio,
        TipoNotificacion tipo
) {}