package com.productivity.app.presentation.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productivity.app.application.dto.request.CrearRecordatorioRequest;
import com.productivity.app.application.usecase.recordatorio.CancelarRecordatorioUseCase;
import com.productivity.app.application.usecase.recordatorio.CrearRecordatorioUseCase;
import com.productivity.app.application.usecase.recordatorio.EnviarRecordatorioUseCase;

@RestController
@RequestMapping("/api/reminders")
public class RecordatorioController {

    private final CrearRecordatorioUseCase crear;
    private final CancelarRecordatorioUseCase cancelar;
    private final EnviarRecordatorioUseCase enviar;

    public RecordatorioController(
            CrearRecordatorioUseCase crear,
            CancelarRecordatorioUseCase cancelar,
            EnviarRecordatorioUseCase enviar
    ) {
        this.crear = crear;
        this.cancelar = cancelar;
        this.enviar = enviar;
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CrearRecordatorioRequest req) {
        return ResponseEntity.ok(crear.execute(req));
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<?> cancelar(@PathVariable UUID id) {
        return ResponseEntity.ok(cancelar.execute(id));
    }

    @PatchMapping("/{id}/send")
    public ResponseEntity<?> enviar(@PathVariable UUID id) {
        return ResponseEntity.ok(enviar.execute(id));
    }
}