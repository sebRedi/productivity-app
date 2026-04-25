package com.productivity.app.application.usecase.proyecto;

import org.springframework.stereotype.Service;

import com.productivity.app.application.dto.request.CrearProyectoRequest;
import com.productivity.app.application.dto.response.ProyectoResponse;
import com.productivity.app.application.mapper.ProyectoMapper;
import com.productivity.app.domain.model.entity.Proyecto;
import com.productivity.app.domain.repository.ProyectoRepository;

@Service
public class CrearProyectoUseCase {

    private final ProyectoRepository proyectoRepository;

    public CrearProyectoUseCase(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public ProyectoResponse execute(CrearProyectoRequest request) {
        Proyecto proyecto = Proyecto.crear(
                request.nombre(),
                request.descripcion(),
                request.usuarioId()
        );

        Proyecto guardado = proyectoRepository.save(proyecto);

        return ProyectoMapper.toResponse(guardado);
    }
}