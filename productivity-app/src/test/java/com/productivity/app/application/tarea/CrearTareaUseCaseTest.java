package com.productivity.app.application.tarea;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.productivity.app.application.dto.request.CrearTareaRequest;
import com.productivity.app.application.usecase.tarea.CrearTareaUseCase;
import com.productivity.app.domain.model.entity.Tarea;
import com.productivity.app.domain.model.valueobject.Prioridad;
import com.productivity.app.domain.repository.TareaRepository;

class CrearTareaUseCaseTest {

    @Test
    void deberiaCrearTarea() {

        TareaRepository repo = mock(TareaRepository.class);

        CrearTareaUseCase useCase = new CrearTareaUseCase(repo);

        CrearTareaRequest request = new CrearTareaRequest(
                "Test",
                "desc",
                Prioridad.ALTA,
                LocalDate.now().plusDays(1),
                UUID.randomUUID(),
                null
        );

        when(repo.save(Mockito.any(Tarea.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        var response = useCase.execute(request);

        assertEquals("Test", response.titulo());
    }
}