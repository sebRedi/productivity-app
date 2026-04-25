package com.productivity.app.application.usecase.tarea;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productivity.app.application.dto.response.TareaResponse;
import com.productivity.app.application.mapper.TareaMapper;
import com.productivity.app.domain.repository.TareaRepository;

@Service
public class ListarTareasUseCase {

    private final TareaRepository tareaRepository;

    public ListarTareasUseCase(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<TareaResponse> execute() {
        return tareaRepository.findAll()
                .stream()
                .map(TareaMapper::toResponse)
                .toList();
    }
}