package com.productivity.app.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.productivity.app.domain.model.valueobject.EstadoRecordatorio;
import com.productivity.app.domain.model.valueobject.TipoNotificacion;

public record RecordatorioResponse(
        UUID id,
        UUID tareaId,
        LocalDateTime fechaRecordatorio,
        TipoNotificacion tipo,
        EstadoRecordatorio estado
) {}