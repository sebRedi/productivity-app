package com.productivity.app.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productivity.app.application.dto.request.CrearUsuarioRequest;
import com.productivity.app.application.dto.response.UsuarioResponse;
import com.productivity.app.application.usecase.usuario.CrearUsuarioUseCase;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {

    private final CrearUsuarioUseCase crearUsuarioUseCase;

    public UsuarioController(CrearUsuarioUseCase crearUsuarioUseCase) {
        this.crearUsuarioUseCase = crearUsuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> crearUsuario(@RequestBody CrearUsuarioRequest request) {
        return ResponseEntity.ok(crearUsuarioUseCase.execute(request));
    }
}