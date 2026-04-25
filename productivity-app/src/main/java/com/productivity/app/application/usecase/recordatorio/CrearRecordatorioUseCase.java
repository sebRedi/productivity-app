package com.productivity.app.application.usecase.recordatorio;

import org.springframework.stereotype.Service;

import com.productivity.app.application.dto.request.CrearRecordatorioRequest;
import com.productivity.app.application.dto.response.RecordatorioResponse;
import com.productivity.app.domain.model.entity.Recordatorio;
import com.productivity.app.domain.repository.RecordatorioRepository;

@Service
public class CrearRecordatorioUseCase {

    private final RecordatorioRepository repo;

    public CrearRecordatorioUseCase(RecordatorioRepository repo) {
        this.repo = repo;
    }

    public RecordatorioResponse execute(CrearRecordatorioRequest req) {
        var r = Recordatorio.crear(req.tareaId(), req.fechaRecordatorio(), req.tipo());
        var saved = repo.save(r);

        return new RecordatorioResponse(
                saved.getId(),
                saved.getTareaId(),
                saved.getFechaRecordatorio(),
                saved.getTipo(),
                saved.getEstado()
        );
    }
}