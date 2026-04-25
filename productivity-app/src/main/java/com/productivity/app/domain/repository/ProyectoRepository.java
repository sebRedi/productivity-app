package com.productivity.app.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.productivity.app.domain.model.entity.Proyecto;

public interface ProyectoRepository {

    Proyecto save(Proyecto proyecto);

    Optional<Proyecto> findById(UUID id);

    List<Proyecto> findAll();

    void deleteById(UUID id);
}