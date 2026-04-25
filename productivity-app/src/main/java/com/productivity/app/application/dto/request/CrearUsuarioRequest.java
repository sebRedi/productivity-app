package com.productivity.app.application.dto.request;

public record CrearUsuarioRequest(
        String nombre,
        String correo
) {}