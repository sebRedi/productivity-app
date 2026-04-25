package com.productivity.app.infrastructure.persistence.mapper;

import com.productivity.app.domain.model.entity.Usuario;
import com.productivity.app.infrastructure.persistence.entity.UsuarioJpaEntity;

public class UsuarioPersistenceMapper {

    public static UsuarioJpaEntity toJpa(Usuario usuario) {
        return new UsuarioJpaEntity(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo().getValor(),
                usuario.getFechaRegistro()
        );
    }

    public static Usuario toDomain(UsuarioJpaEntity entity) {
        return Usuario.reconstruir(
                entity.getId(),
                entity.getNombre(),
                entity.getCorreo(),
                entity.getFechaRegistro()
        );
    }
}