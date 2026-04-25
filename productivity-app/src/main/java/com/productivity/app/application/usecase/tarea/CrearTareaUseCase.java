package com.productivity.app.application.usecase.tarea;

import org.springframework.stereotype.Service;

import com.productivity.app.application.dto.request.CrearTareaRequest;
import com.productivity.app.application.dto.response.TareaResponse;
import com.productivity.app.application.mapper.TareaMapper;
import com.productivity.app.domain.model.entity.Tarea;
import com.productivity.app.domain.repository.TareaRepository;

@Service
public class CrearTareaUseCase {

    private final TareaRepository tareaRepository;

    public CrearTareaUseCase(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public TareaResponse execute(CrearTareaRequest request) {
        Tarea tarea = Tarea.crear(
                request.titulo(),
                request.descripcion(),
                request.prioridad(),
                request.fechaLimite(),
                request.usuarioId(),
                request.proyectoId()
        );

        Tarea tareaGuardada = tareaRepository.save(tarea);

        return TareaMapper.toResponse(tareaGuardada);
    }
}