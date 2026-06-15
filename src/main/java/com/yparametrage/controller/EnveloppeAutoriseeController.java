package com.yparametrage.controller;

import com.yparametrage.dto.EnveloppeAutoriseeDTO;
import com.yparametrage.service.EnveloppeAutoriseeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enveloppe-autorisee")
@CrossOrigin(origins = "*")
public class EnveloppeAutoriseeController {
    @Autowired
    private EnveloppeAutoriseeService service;

    @PostMapping
    public ResponseEntity<EnveloppeAutoriseeDTO> create(@Valid @RequestBody EnveloppeAutoriseeDTO dto) {
        EnveloppeAutoriseeDTO created = service.create(dto);
        return created != null ? new ResponseEntity<>(created, HttpStatus.CREATED) : ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<EnveloppeAutoriseeDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnveloppeAutoriseeDTO> getById(@PathVariable Integer id) {
        Optional<EnveloppeAutoriseeDTO> enveloppe = service.getById(id);
        return enveloppe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnveloppeAutoriseeDTO> update(@PathVariable Integer id, @Valid @RequestBody EnveloppeAutoriseeDTO dto) {
        EnveloppeAutoriseeDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/plp/{plpId}")
    public ResponseEntity<List<EnveloppeAutoriseeDTO>> findByPlpId(@PathVariable Integer plpId) {
        return ResponseEntity.ok(service.findByPlpId(plpId));
    }
}