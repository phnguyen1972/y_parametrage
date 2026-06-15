package com.yparametrage.controller;

import com.yparametrage.dto.JdeDTO;
import com.yparametrage.service.JdeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jde")
@CrossOrigin(origins = "*")
public class JdeController {
    @Autowired
    private JdeService jdeService;

    @PostMapping("/insert")
    public ResponseEntity<JdeDTO> createInsert(@Valid @RequestBody JdeDTO dto) {
        return new ResponseEntity<>(jdeService.createInsert(dto), HttpStatus.CREATED);
    }

    @GetMapping("/insert")
    public ResponseEntity<List<JdeDTO>> getAllInserts() {
        return ResponseEntity.ok(jdeService.getAllInserts());
    }

    @GetMapping("/insert/{id}")
    public ResponseEntity<JdeDTO> getInsertById(@PathVariable Integer id) {
        Optional<JdeDTO> insert = jdeService.getInsertById(id);
        return insert.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/insert/{id}")
    public ResponseEntity<Void> deleteInsert(@PathVariable Integer id) {
        return jdeService.deleteInsert(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/support")
    public ResponseEntity<JdeDTO> createSupport(@Valid @RequestBody JdeDTO dto) {
        return new ResponseEntity<>(jdeService.createSupport(dto), HttpStatus.CREATED);
    }

    @GetMapping("/support")
    public ResponseEntity<List<JdeDTO>> getAllSupports() {
        return ResponseEntity.ok(jdeService.getAllSupports());
    }

    @GetMapping("/support/{id}")
    public ResponseEntity<JdeDTO> getSupportById(@PathVariable Integer id) {
        Optional<JdeDTO> support = jdeService.getSupportById(id);
        return support.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/support/{id}")
    public ResponseEntity<Void> deleteSupport(@PathVariable Integer id) {
        return jdeService.deleteSupport(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/enveloppe")
    public ResponseEntity<JdeDTO> createEnveloppe(@Valid @RequestBody JdeDTO dto) {
        return new ResponseEntity<>(jdeService.createEnveloppe(dto), HttpStatus.CREATED);
    }

    @GetMapping("/enveloppe")
    public ResponseEntity<List<JdeDTO>> getAllEnveloppes() {
        return ResponseEntity.ok(jdeService.getAllEnveloppes());
    }

    @GetMapping("/enveloppe/{id}")
    public ResponseEntity<JdeDTO> getEnveloppeById(@PathVariable Integer id) {
        Optional<JdeDTO> enveloppe = jdeService.getEnveloppeById(id);
        return enveloppe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/enveloppe/{id}")
    public ResponseEntity<Void> deleteEnveloppe(@PathVariable Integer id) {
        return jdeService.deleteEnveloppe(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}