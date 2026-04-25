package com.productivity.app.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.productivity.app.domain.model.entity.Proyecto;
import com.productivity.app.domain.repository.ProyectoRepository;
import com.productivity.app.infrastructure.persistence.jpa.ProyectoJpaRepository;
import com.productivity.app.infrastructure.persistence.mapper.ProyectoPersistenceMapper;

@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository {

    private final ProyectoJpaRepository proyectoJpaRepository;

    public ProyectoRepositoryImpl(ProyectoJpaRepository proyectoJpaRepository) {
        this.proyectoJpaRepository = proyectoJpaRepository;
    }

    @Override
    public Proyecto save(Proyecto proyecto) {
        return ProyectoPersistenceMapper.toDomain(
                proyectoJpaRepository.save(ProyectoPersistenceMapper.toJpaEntity(proyecto))
        );
    }

    @Override
    public Optional<Proyecto> findById(UUID id) {
        return proyectoJpaRepository.findById(id)
                .map(ProyectoPersistenceMapper::toDomain);
    }

    @Override
    public List<Proyecto> findAll() {
        return proyectoJpaRepository.findAll()
                .stream()
                .map(ProyectoPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        proyectoJpaRepository.deleteById(id);
    }
}