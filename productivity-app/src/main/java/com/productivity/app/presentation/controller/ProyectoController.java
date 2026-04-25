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

import com.productivity.app.application.dto.request.ActualizarProyectoRequest;
import com.productivity.app.application.dto.request.CrearProyectoRequest;
import com.productivity.app.application.dto.response.ProyectoResponse;
import com.productivity.app.application.usecase.proyecto.ActualizarProyectoUseCase;
import com.productivity.app.application.usecase.proyecto.ArchivarProyectoUseCase;
import com.productivity.app.application.usecase.proyecto.CompletarProyectoUseCase;
import com.productivity.app.application.usecase.proyecto.CrearProyectoUseCase;
import com.productivity.app.application.usecase.proyecto.EliminarProyectoUseCase;
import com.productivity.app.application.usecase.proyecto.ListarProyectosUseCase;
import com.productivity.app.application.usecase.proyecto.ObtenerProyectoPorIdUseCase;

@RestController
@RequestMapping("/api/projects")
public class ProyectoController {

    private final CrearProyectoUseCase crearProyectoUseCase;
    private final ObtenerProyectoPorIdUseCase obtenerProyectoPorIdUseCase;
    private final ListarProyectosUseCase listarProyectosUseCase;
    private final ActualizarProyectoUseCase actualizarProyectoUseCase;
    private final ArchivarProyectoUseCase archivarProyectoUseCase;
    private final CompletarProyectoUseCase completarProyectoUseCase;
    private final EliminarProyectoUseCase eliminarProyectoUseCase;

    public ProyectoController(
            CrearProyectoUseCase crearProyectoUseCase,
            ObtenerProyectoPorIdUseCase obtenerProyectoPorIdUseCase,
            ListarProyectosUseCase listarProyectosUseCase,
            ActualizarProyectoUseCase actualizarProyectoUseCase,
            ArchivarProyectoUseCase archivarProyectoUseCase,
            CompletarProyectoUseCase completarProyectoUseCase,
            EliminarProyectoUseCase eliminarProyectoUseCase
    ) {
        this.crearProyectoUseCase = crearProyectoUseCase;
        this.obtenerProyectoPorIdUseCase = obtenerProyectoPorIdUseCase;
        this.listarProyectosUseCase = listarProyectosUseCase;
        this.actualizarProyectoUseCase = actualizarProyectoUseCase;
        this.archivarProyectoUseCase = archivarProyectoUseCase;
        this.completarProyectoUseCase = completarProyectoUseCase;
        this.eliminarProyectoUseCase = eliminarProyectoUseCase;
    }

    @PostMapping
    public ResponseEntity<ProyectoResponse> crearProyecto(@RequestBody CrearProyectoRequest request) {
        ProyectoResponse response = crearProyectoUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoResponse> obtenerProyectoPorId(@PathVariable UUID id) {
        ProyectoResponse response = obtenerProyectoPorIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProyectoResponse>> listarProyectos() {
        List<ProyectoResponse> response = listarProyectosUseCase.execute();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoResponse> actualizarProyecto(
            @PathVariable UUID id,
            @RequestBody ActualizarProyectoRequest request
    ) {
        ProyectoResponse response = actualizarProyectoUseCase.execute(id, request);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/archive")
    public ResponseEntity<ProyectoResponse> archivarProyecto(@PathVariable UUID id) {
        ProyectoResponse response = archivarProyectoUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<ProyectoResponse> completarProyecto(@PathVariable UUID id) {
        ProyectoResponse response = completarProyectoUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable UUID id) {
        eliminarProyectoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}