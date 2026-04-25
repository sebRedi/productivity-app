package com.productivity.app.infrastructure.persistence.mapper;

import com.productivity.app.domain.model.entity.Recordatorio;
import com.productivity.app.infrastructure.persistence.entity.RecordatorioJpaEntity;

public class RecordatorioMapper {

    public static RecordatorioJpaEntity toJpa(Recordatorio r) {
        return new RecordatorioJpaEntity(
                r.getId(),
                r.getTareaId(),
                r.getFechaRecordatorio(),
                r.getTipo(),
                r.getEstado()
        );
    }

    public static Recordatorio toDomain(RecordatorioJpaEntity e) {
        return Recordatorio.reconstruir(
                e.getId(),
                e.getTareaId(),
                e.getFechaRecordatorio(),
                e.getTipo(),
                e.getEstado()
        );
    }
}