package com.api.trabalho_bd.controllers;

import com.api.trabalho_bd.dtos.forms.CreateConsultaForm;
import com.api.trabalho_bd.dtos.forms.UpdateConsultaForm;
import com.api.trabalho_bd.entities.Consulta;
import com.api.trabalho_bd.entities.Medico;
import com.api.trabalho_bd.services.ConsultaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private final ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateConsultaForm dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.create(dto));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<Consulta> lista = consultaService.findAll();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        return ResponseEntity.ok().body(consultaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody UpdateConsultaForm dto) {
        return ResponseEntity.ok().body(consultaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        consultaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
