package com.productivity.app.application.usecase.tarea;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.productivity.app.domain.exception.TareaNoEncontradaException;
import com.productivity.app.domain.repository.TareaRepository;

@Service
public class EliminarTareaUseCase {

    private final TareaRepository tareaRepository;

    public EliminarTareaUseCase(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public void execute(UUID id) {
        tareaRepository.findById(id)
                .orElseThrow(TareaNoEncontradaException::new);

        tareaRepository.deleteById(id);
    }
}