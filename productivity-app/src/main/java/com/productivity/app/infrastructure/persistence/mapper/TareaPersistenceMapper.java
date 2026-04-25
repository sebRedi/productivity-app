package com.productivity.app.infrastructure.persistence.mapper;

import com.productivity.app.domain.model.entity.Tarea;
import com.productivity.app.infrastructure.persistence.entity.TareaJpaEntity;

public class TareaPersistenceMapper {

    private TareaPersistenceMapper() {
    }

    public static TareaJpaEntity toJpaEntity(Tarea tarea) {
        return new TareaJpaEntity(
                tarea.getId(),
                tarea.getTitulo(),
                tarea.getDescripcion(),
                tarea.getEstado(),
                tarea.getPrioridad(),
                tarea.getFechaLimite(),
                tarea.getUsuarioId(),
                tarea.getProyectoId(),
                tarea.getFechaCreacion()
        );
    }

    public static Tarea toDomain(TareaJpaEntity entity) {
        return Tarea.reconstruir(
                entity.getId(),
                entity.getTitulo(),
                entity.getDescripcion(),
                entity.getEstado(),
                entity.getPrioridad(),
                entity.getFechaLimite(),
                entity.getUsuarioId(),
                entity.getProyectoId(),
                entity.getFechaCreacion()
        );
    }
}