package com.productivity.app.infrastructure.persistence.mapper;

import com.productivity.app.domain.model.entity.Proyecto;
import com.productivity.app.infrastructure.persistence.entity.ProyectoJpaEntity;

public class ProyectoPersistenceMapper {

    private ProyectoPersistenceMapper() {
    }

    public static ProyectoJpaEntity toJpaEntity(Proyecto proyecto) {
        return new ProyectoJpaEntity(
                proyecto.getId(),
                proyecto.getNombre(),
                proyecto.getDescripcion(),
                proyecto.getUsuarioId(),
                proyecto.getEstado(),
                proyecto.getFechaCreacion()
        );
    }

    public static Proyecto toDomain(ProyectoJpaEntity entity) {
        return Proyecto.reconstruir(
                entity.getId(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getUsuarioId(),
                entity.getEstado(),
                entity.getFechaCreacion()
        );
    }
}