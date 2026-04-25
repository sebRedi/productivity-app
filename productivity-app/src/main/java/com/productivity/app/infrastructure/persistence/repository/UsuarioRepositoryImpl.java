package com.productivity.app.infrastructure.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.productivity.app.domain.model.entity.Usuario;
import com.productivity.app.domain.repository.UsuarioRepository;
import com.productivity.app.infrastructure.persistence.jpa.UsuarioJpaRepository;
import com.productivity.app.infrastructure.persistence.mapper.UsuarioPersistenceMapper;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final UsuarioJpaRepository jpaRepository;

    public UsuarioRepositoryImpl(UsuarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return UsuarioPersistenceMapper.toDomain(
                jpaRepository.save(UsuarioPersistenceMapper.toJpa(usuario))
        );
    }

    @Override
    public Optional<Usuario> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(UsuarioPersistenceMapper::toDomain);
    }
}