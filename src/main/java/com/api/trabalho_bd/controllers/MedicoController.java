package com.api.trabalho_bd.controllers;

import com.api.trabalho_bd.dtos.forms.CreateMedicoForm;
import com.api.trabalho_bd.dtos.forms.UpdateMedicoForm;
import com.api.trabalho_bd.entities.Medico;
import com.api.trabalho_bd.services.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private final MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateMedicoForm dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.create(dto));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<Medico> lista = medicoService.findAll();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        return ResponseEntity.ok().body(medicoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody UpdateMedicoForm dto) {
        return ResponseEntity.ok().body(medicoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        medicoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
