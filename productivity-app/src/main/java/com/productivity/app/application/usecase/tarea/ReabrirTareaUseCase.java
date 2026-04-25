package com.productivity.app.application.usecase.tarea;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.productivity.app.application.dto.response.TareaResponse;
import com.productivity.app.application.mapper.TareaMapper;
import com.productivity.app.domain.exception.TareaNoEncontradaException;
import com.productivity.app.domain.model.entity.Tarea;
import com.productivity.app.domain.repository.TareaRepository;

@Service
public class ReabrirTareaUseCase {

    private final TareaRepository tareaRepository;

    public ReabrirTareaUseCase(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public TareaResponse execute(UUID id) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(TareaNoEncontradaException::new);

        tarea.reabrir();

        Tarea tareaActualizada = tareaRepository.save(tarea);

        return TareaMapper.toResponse(tareaActualizada);
    }
}