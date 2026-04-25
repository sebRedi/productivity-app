package com.productivity.app.infrastructure.persistence.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productivity.app.infrastructure.persistence.entity.UsuarioJpaEntity;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioJpaEntity, UUID> {
}