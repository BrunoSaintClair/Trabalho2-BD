package com.api.trabalho_bd.controllers.mongo;

import com.api.trabalho_bd.entities.mongo.ProcedimentoMongo;
import com.api.trabalho_bd.services.mongo.ProcedimentoMongoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/mongo/procedimentos")
public class ProcedimentoMongoController {

    @Autowired
    private final ProcedimentoMongoService procedimentoMongoService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ProcedimentoMongo procedimento) {
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody ProcedimentoMongo procedimento) {
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
    }

}