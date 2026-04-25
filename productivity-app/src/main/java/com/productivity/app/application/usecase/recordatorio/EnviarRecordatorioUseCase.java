package com.productivity.app.application.usecase.recordatorio;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.productivity.app.application.dto.response.RecordatorioResponse;
import com.productivity.app.domain.repository.RecordatorioRepository;

@Service
public class EnviarRecordatorioUseCase {

    private final RecordatorioRepository repo;

    public EnviarRecordatorioUseCase(RecordatorioRepository repo) {
        this.repo = repo;
    }

    public RecordatorioResponse execute(UUID id) {
        var r = repo.findById(id).orElseThrow();
        r.marcarEnviado();

        return new RecordatorioResponse(
                r.getId(), r.getTareaId(),
                r.getFechaRecordatorio(),
                r.getTipo(), r.getEstado()
        );
    }
}