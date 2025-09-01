package com.api.trabalho_bd.controllers.mongo;

import com.api.trabalho_bd.entities.mongo.PacienteMongo;
import com.api.trabalho_bd.services.mongo.PacienteMongoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/mongo/pacientes")
public class PacienteMongoController {

    @Autowired
    private final PacienteMongoService pacienteMongoService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Object paciente) {
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody PacienteMongo paciente) {
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
    }

}