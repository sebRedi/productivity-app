package com.productivity.app.domain;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.productivity.app.domain.exception.DomainException;
import com.productivity.app.domain.model.entity.Proyecto;

class ProyectoTest {

    @Test
    void deberiaCrearProyectoCorrectamente() {
        Proyecto proyecto = Proyecto.crear(
                "Proyecto 1",
                "Descripción",
                UUID.randomUUID()
        );

        assertEquals("Proyecto 1", proyecto.getNombre());
    }

    @Test
    void noDebePermitirNombreVacio() {
        assertThrows(DomainException.class, () ->
                Proyecto.crear("", "desc", UUID.randomUUID())
        );
    }

    @Test
    void deberiaCompletarProyecto() {
        Proyecto proyecto = Proyecto.crear(
                "Proyecto",
                "desc",
                UUID.randomUUID()
        );

        proyecto.completar();

        assertEquals("COMPLETADO", proyecto.getEstado().name());
    }
}