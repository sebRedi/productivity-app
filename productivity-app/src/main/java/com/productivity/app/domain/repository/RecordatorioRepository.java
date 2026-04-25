package com.productivity.app.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.productivity.app.domain.model.entity.Recordatorio;

public interface RecordatorioRepository {

    Recordatorio save(Recordatorio recordatorio);

    Optional<Recordatorio> findById(UUID id);

    List<Recordatorio> findAll();

    void deleteById(UUID id);
}