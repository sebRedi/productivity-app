package com.productivity.app.application.usecase.usuario;

import org.springframework.stereotype.Service;

import com.productivity.app.application.dto.request.CrearUsuarioRequest;
import com.productivity.app.application.dto.response.UsuarioResponse;
import com.productivity.app.domain.model.entity.Usuario;
import com.productivity.app.domain.repository.UsuarioRepository;

@Service
public class CrearUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public CrearUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponse execute(CrearUsuarioRequest request) {

        Usuario usuario = Usuario.crear(
                request.nombre(),
                request.correo()
        );

        Usuario guardado = usuarioRepository.save(usuario);

        return new UsuarioResponse(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getCorreo().getValor(),
                guardado.getFechaRegistro()
        );
    }
}