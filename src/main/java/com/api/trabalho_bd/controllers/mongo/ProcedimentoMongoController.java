package com.api.trabalho_bd.controllers.mongo;

import com.api.trabalho_bd.dtos.forms.mongo.CreateProcedimentoMongoForm;
import com.api.trabalho_bd.dtos.forms.mongo.UpdateProcedimentoMongoForm;
import com.api.trabalho_bd.entities.mongo.ProcedimentoMongo;
import com.api.trabalho_bd.services.mongo.ProcedimentoMongoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/mongo/procedimentos")
public class ProcedimentoMongoController {

    @Autowired
    private final ProcedimentoMongoService procedimentoMongoService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateProcedimentoMongoForm dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(procedimentoMongoService.create(dto));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<ProcedimentoMongo> lista = procedimentoMongoService.findAll();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        return ResponseEntity.ok(procedimentoMongoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody UpdateProcedimentoMongoForm dto) {
        return ResponseEntity.ok(procedimentoMongoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        procedimentoMongoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}