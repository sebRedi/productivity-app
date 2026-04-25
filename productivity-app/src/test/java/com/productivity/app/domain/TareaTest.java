package com.productivity.app.domain;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.productivity.app.domain.exception.DomainException;
import com.productivity.app.domain.model.entity.Tarea;
import com.productivity.app.domain.model.valueobject.Prioridad;

class TareaTest {

    @Test
    void deberiaCrearTareaCorrectamente() {
        Tarea tarea = Tarea.crear(
                "Estudiar",
                "DDD",
                Prioridad.ALTA,
                LocalDate.now().plusDays(1),
                UUID.randomUUID(),
                null
        );

        assertEquals("Estudiar", tarea.getTitulo());
        assertEquals(Prioridad.ALTA, tarea.getPrioridad());
    }

    @Test
    void noDeberiaPermitirTituloVacio() {
        assertThrows(DomainException.class, () ->
                Tarea.crear("", "desc", Prioridad.MEDIA,
                        LocalDate.now().plusDays(1),
                        UUID.randomUUID(),
                        null)
        );
    }

    @Test
    void deberiaCompletarTarea() {
        Tarea tarea = Tarea.crear(
                "Test", "desc", Prioridad.MEDIA,
                LocalDate.now().plusDays(1),
                UUID.randomUUID(),
                null
        );

        tarea.completar();

        assertEquals("COMPLETADA", tarea.getEstado().name());
    }
}