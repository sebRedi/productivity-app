package com.productivity.app.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.productivity.app.domain.model.entity.Tarea;
import com.productivity.app.domain.repository.TareaRepository;
import com.productivity.app.infrastructure.persistence.jpa.TareaJpaRepository;
import com.productivity.app.infrastructure.persistence.mapper.TareaPersistenceMapper;

@Repository
public class TareaRepositoryImpl implements TareaRepository {

    private final TareaJpaRepository tareaJpaRepository;

    public TareaRepositoryImpl(TareaJpaRepository tareaJpaRepository) {
        this.tareaJpaRepository = tareaJpaRepository;
    }

    @Override
    public Tarea save(Tarea tarea) {
        return TareaPersistenceMapper.toDomain(
                tareaJpaRepository.save(TareaPersistenceMapper.toJpaEntity(tarea))
        );
    }

    @Override
    public Optional<Tarea> findById(UUID id) {
        return tareaJpaRepository.findById(id)
                .map(TareaPersistenceMapper::toDomain);
    }

    @Override
    public List<Tarea> findAll() {
        return tareaJpaRepository.findAll()
                .stream()
                .map(TareaPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        tareaJpaRepository.deleteById(id);
    }
}