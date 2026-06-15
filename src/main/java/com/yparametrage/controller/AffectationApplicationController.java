package com.yparametrage.controller;

import com.yparametrage.dto.AffectationApplicationDTO;
import com.yparametrage.service.AffectationApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/affectation-application")
@CrossOrigin(origins = "*")
public class AffectationApplicationController {
    @Autowired
    private AffectationApplicationService service;

    @PostMapping
    public ResponseEntity<AffectationApplicationDTO> create(@Valid @RequestBody AffectationApplicationDTO dto) {
        AffectationApplicationDTO created = service.create(dto);
        return created != null ? new ResponseEntity<>(created, HttpStatus.CREATED) : ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<AffectationApplicationDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AffectationApplicationDTO> getById(@PathVariable Integer id) {
        Optional<AffectationApplicationDTO> affectation = service.getById(id);
        return affectation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffectationApplicationDTO> update(@PathVariable Integer id, @Valid @RequestBody AffectationApplicationDTO dto) {
        AffectationApplicationDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/plp/{plpId}")
    public ResponseEntity<List<AffectationApplicationDTO>> findByPlpId(@PathVariable Integer plpId) {
        return ResponseEntity.ok(service.findByPlpId(plpId));
    }
}