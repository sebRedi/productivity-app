package com.productivity.app.application.usecase.proyecto;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.productivity.app.domain.exception.ProyectoNoEncontradoException;
import com.productivity.app.domain.repository.ProyectoRepository;

@Service
public class EliminarProyectoUseCase {

    private final ProyectoRepository proyectoRepository;

    public EliminarProyectoUseCase(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public void execute(UUID id) {
        proyectoRepository.findById(id)
                .orElseThrow(ProyectoNoEncontradoException::new);

        proyectoRepository.deleteById(id);
    }
}