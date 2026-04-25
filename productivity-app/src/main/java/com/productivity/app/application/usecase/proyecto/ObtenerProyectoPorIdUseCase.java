package com.productivity.app.application.usecase.proyecto;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.productivity.app.application.dto.response.ProyectoResponse;
import com.productivity.app.application.mapper.ProyectoMapper;
import com.productivity.app.domain.exception.ProyectoNoEncontradoException;
import com.productivity.app.domain.model.entity.Proyecto;
import com.productivity.app.domain.repository.ProyectoRepository;

@Service
public class ObtenerProyectoPorIdUseCase {

    private final ProyectoRepository proyectoRepository;

    public ObtenerProyectoPorIdUseCase(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public ProyectoResponse execute(UUID id) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(ProyectoNoEncontradoException::new);

        return ProyectoMapper.toResponse(proyecto);
    }
}