package com.productivity.app.application.mapper;

import com.productivity.app.application.dto.response.ProyectoResponse;
import com.productivity.app.domain.model.entity.Proyecto;

public class ProyectoMapper {

    private ProyectoMapper() {
    }

    public static ProyectoResponse toResponse(Proyecto proyecto) {
        return new ProyectoResponse(
                proyecto.getId(),
                proyecto.getNombre(),
                proyecto.getDescripcion(),
                proyecto.getUsuarioId(),
                proyecto.getEstado(),
                proyecto.getFechaCreacion()
        );
    }
}