package com.api.trabalho_bd.controllers.mongo;

import com.api.trabalho_bd.dtos.forms.mongo.CreatePacienteMongoForm;
import com.api.trabalho_bd.dtos.forms.mongo.UpdatePacienteMongoForm;
import com.api.trabalho_bd.entities.mongo.PacienteMongo;
import com.api.trabalho_bd.services.mongo.PacienteMongoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/mongo/pacientes")
public class PacienteMongoController {

    @Autowired
    private final PacienteMongoService pacienteMongoService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreatePacienteMongoForm dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteMongoService.create(dto));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<PacienteMongo> lista = pacienteMongoService.findAll();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        return ResponseEntity.ok(pacienteMongoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody UpdatePacienteMongoForm dto) {
        return ResponseEntity.ok(pacienteMongoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        pacienteMongoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}