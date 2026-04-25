package com.productivity.app.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.productivity.app.domain.model.entity.Recordatorio;
import com.productivity.app.domain.repository.RecordatorioRepository;
import com.productivity.app.infrastructure.persistence.jpa.RecordatorioJpaRepository;
import com.productivity.app.infrastructure.persistence.mapper.RecordatorioMapper;

@Repository
public class RecordatorioRepositoryImpl implements RecordatorioRepository {

    private final RecordatorioJpaRepository repo;

    public RecordatorioRepositoryImpl(RecordatorioJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Recordatorio save(Recordatorio r) {
        return RecordatorioMapper.toDomain(
                repo.save(RecordatorioMapper.toJpa(r))
        );
    }

    @Override
    public Optional<Recordatorio> findById(UUID id) {
        return repo.findById(id).map(RecordatorioMapper::toDomain);
    }

    @Override
    public List<Recordatorio> findAll() {
        return repo.findAll().stream()
                .map(RecordatorioMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }
}