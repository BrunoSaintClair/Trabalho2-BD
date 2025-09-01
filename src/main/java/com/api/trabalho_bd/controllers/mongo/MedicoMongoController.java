package com.api.trabalho_bd.controllers.mongo;

import com.api.trabalho_bd.entities.mongo.MedicoMongo;
import com.api.trabalho_bd.services.mongo.MedicoMongoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/mongo/medicos")
public class MedicoMongoController {

    @Autowired
    private final MedicoMongoService medicoMongoService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody MedicoMongo medico) {
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody MedicoMongo medico) {
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
    }

}