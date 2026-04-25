package com.productivity.app.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.productivity.app.domain.exception.DomainException;
import com.productivity.app.domain.model.entity.Usuario;

class UsuarioTest {

    @Test
    void deberiaCrearUsuarioCorrectamente() {
        Usuario usuario = Usuario.crear("Sebas", "test@mail.com");

        assertEquals("Sebas", usuario.getNombre());
    }

    @Test
    void noDebePermitirCorreoInvalido() {
        assertThrows(DomainException.class, () ->
                Usuario.crear("Sebas", "correo_invalido")
        );
    }
}