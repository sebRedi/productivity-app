package com.productivity.app.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.productivity.app.domain.model.entity.Usuario;

public interface UsuarioRepository {

    Usuario save(Usuario usuario);

    Optional<Usuario> findById(UUID id);
}