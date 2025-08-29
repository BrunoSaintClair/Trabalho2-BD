package com.api.trabalho_bd.controllers;

import com.api.trabalho_bd.dtos.forms.CreatePacienteForm;
import com.api.trabalho_bd.dtos.forms.UpdatePacienteForm;
import com.api.trabalho_bd.services.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreatePacienteForm dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.create(dto));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok(pacienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(pacienteService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody UpdatePacienteForm dto) {
        return ResponseEntity.ok().body(pacienteService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
