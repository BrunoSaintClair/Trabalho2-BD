package com.api.trabalho_bd.controllers.mongo;

import com.api.trabalho_bd.dtos.forms.mongo.CreateMedicoMongoForm;
import com.api.trabalho_bd.dtos.forms.mongo.UpdateMedicoMongoForm;
import com.api.trabalho_bd.entities.mongo.MedicoMongo;
import com.api.trabalho_bd.services.mongo.MedicoMongoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/mongo/medicos")
public class MedicoMongoController {

    @Autowired
    private final MedicoMongoService medicoMongoService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateMedicoMongoForm dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoMongoService.create(dto));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<MedicoMongo> lista = medicoMongoService.findAll();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        return ResponseEntity.ok(medicoMongoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody UpdateMedicoMongoForm dto) {
        return ResponseEntity.ok(medicoMongoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        medicoMongoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}