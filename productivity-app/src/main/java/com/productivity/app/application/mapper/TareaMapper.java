package com.productivity.app.application.mapper;

import com.productivity.app.application.dto.response.TareaResponse;
import com.productivity.app.domain.model.entity.Tarea;

public class TareaMapper {

    private TareaMapper() {
    }

    public static TareaResponse toResponse(Tarea tarea) {
        return new TareaResponse(
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
}