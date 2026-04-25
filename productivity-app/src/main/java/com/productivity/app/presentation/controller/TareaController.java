package com.productivity.app.presentation.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productivity.app.application.dto.request.ActualizarTareaRequest;
import com.productivity.app.application.dto.request.CrearTareaRequest;
import com.productivity.app.application.dto.response.TareaResponse;
import com.productivity.app.application.usecase.tarea.ActualizarTareaUseCase;
import com.productivity.app.application.usecase.tarea.CancelarTareaUseCase;
import com.productivity.app.application.usecase.tarea.CompletarTareaUseCase;
import com.productivity.app.application.usecase.tarea.CrearTareaUseCase;
import com.productivity.app.application.usecase.tarea.EliminarTareaUseCase;
import com.productivity.app.application.usecase.tarea.ListarTareasUseCase;
import com.productivity.app.application.usecase.tarea.ObtenerTareaPorIdUseCase;
import com.productivity.app.application.usecase.tarea.ReabrirTareaUseCase;

@RestController
@RequestMapping("/api/tasks")
public class TareaController {

    private final CrearTareaUseCase crearTareaUseCase;
    private final ObtenerTareaPorIdUseCase obtenerTareaPorIdUseCase;
    private final ListarTareasUseCase listarTareasUseCase;
    private final ActualizarTareaUseCase actualizarTareaUseCase;
    private final CompletarTareaUseCase completarTareaUseCase;
    private final CancelarTareaUseCase cancelarTareaUseCase;
    private final ReabrirTareaUseCase reabrirTareaUseCase;
    private final EliminarTareaUseCase eliminarTareaUseCase;

    public TareaController(
            CrearTareaUseCase crearTareaUseCase,
            ObtenerTareaPorIdUseCase obtenerTareaPorIdUseCase,
            ListarTareasUseCase listarTareasUseCase,
            ActualizarTareaUseCase actualizarTareaUseCase,
            CompletarTareaUseCase completarTareaUseCase,
            CancelarTareaUseCase cancelarTareaUseCase,
            ReabrirTareaUseCase reabrirTareaUseCase,
            EliminarTareaUseCase eliminarTareaUseCase
    ) {
        this.crearTareaUseCase = crearTareaUseCase;
        this.obtenerTareaPorIdUseCase = obtenerTareaPorIdUseCase;
        this.listarTareasUseCase = listarTareasUseCase;
        this.actualizarTareaUseCase = actualizarTareaUseCase;
        this.completarTareaUseCase = completarTareaUseCase;
        this.cancelarTareaUseCase = cancelarTareaUseCase;
        this.reabrirTareaUseCase = reabrirTareaUseCase;
        this.eliminarTareaUseCase = eliminarTareaUseCase;
    }

    @PostMapping
    public ResponseEntity<TareaResponse> crearTarea(@RequestBody CrearTareaRequest request) {
        TareaResponse response = crearTareaUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareaResponse> obtenerTareaPorId(@PathVariable UUID id) {
        TareaResponse response = obtenerTareaPorIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TareaResponse>> listarTareas() {
        List<TareaResponse> response = listarTareasUseCase.execute();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareaResponse> actualizarTarea(
            @PathVariable UUID id,
            @RequestBody ActualizarTareaRequest request
    ) {
        TareaResponse response = actualizarTareaUseCase.execute(id, request);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TareaResponse> completarTarea(@PathVariable UUID id) {
        TareaResponse response = completarTareaUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<TareaResponse> cancelarTarea(@PathVariable UUID id) {
        TareaResponse response = cancelarTareaUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/reopen")
    public ResponseEntity<TareaResponse> reabrirTarea(@PathVariable UUID id) {
        TareaResponse response = reabrirTareaUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable UUID id) {
        eliminarTareaUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}