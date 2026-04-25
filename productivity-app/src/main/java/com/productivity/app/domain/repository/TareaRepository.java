package com.productivity.app.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.productivity.app.domain.model.entity.Tarea;

public interface TareaRepository {

    Tarea save(Tarea tarea);

    Optional<Tarea> findById(UUID id);

    List<Tarea> findAll();

    void deleteById(UUID id);
}