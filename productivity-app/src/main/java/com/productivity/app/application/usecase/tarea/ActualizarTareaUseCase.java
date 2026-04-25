package com.productivity.app.application.usecase.tarea;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.productivity.app.application.dto.request.ActualizarTareaRequest;
import com.productivity.app.application.dto.response.TareaResponse;
import com.productivity.app.application.mapper.TareaMapper;
import com.productivity.app.domain.exception.TareaNoEncontradaException;
import com.productivity.app.domain.model.entity.Tarea;
import com.productivity.app.domain.repository.TareaRepository;

@Service
public class ActualizarTareaUseCase {

    private final TareaRepository tareaRepository;

    public ActualizarTareaUseCase(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public TareaResponse execute(UUID id, ActualizarTareaRequest request) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(TareaNoEncontradaException::new);

        tarea.actualizarInformacion(
                request.titulo(),
                request.descripcion(),
                request.fechaLimite()
        );

        Tarea tareaActualizada = tareaRepository.save(tarea);

        return TareaMapper.toResponse(tareaActualizada);
    }
}