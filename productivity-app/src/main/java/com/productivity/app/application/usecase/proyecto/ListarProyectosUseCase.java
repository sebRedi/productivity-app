package com.productivity.app.application.usecase.proyecto;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productivity.app.application.dto.response.ProyectoResponse;
import com.productivity.app.application.mapper.ProyectoMapper;
import com.productivity.app.domain.repository.ProyectoRepository;

@Service
public class ListarProyectosUseCase {

    private final ProyectoRepository proyectoRepository;

    public ListarProyectosUseCase(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<ProyectoResponse> execute() {
        return proyectoRepository.findAll()
                .stream()
                .map(ProyectoMapper::toResponse)
                .toList();
    }
}