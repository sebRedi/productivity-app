package com.productivity.app.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.productivity.app.domain.exception.DomainException;
import com.productivity.app.domain.model.entity.Recordatorio;
import com.productivity.app.domain.model.valueobject.TipoNotificacion;

class RecordatorioTest {

    @Test
    void deberiaCrearRecordatorio() {
        Recordatorio r = Recordatorio.crear(
                UUID.randomUUID(),
                LocalDateTime.now().plusHours(1),
                TipoNotificacion.EMAIL
        );

        assertEquals("PROGRAMADO", r.getEstado().name());
    }

    @Test
    void noDebePermitirFechaPasada() {
        assertThrows(DomainException.class, () ->
                Recordatorio.crear(
                        UUID.randomUUID(),
                        LocalDateTime.now().minusHours(1),
                        TipoNotificacion.EMAIL
                )
        );
    }
}