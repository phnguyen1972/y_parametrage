package com.yparametrage.controller;

import com.yparametrage.dto.FlagRegroupementDTO;
import com.yparametrage.service.FlagRegroupementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flag-regroupement")
@CrossOrigin(origins = "*")
public class FlagRegroupementController {
    @Autowired
    private FlagRegroupementService service;

    @PostMapping
    public ResponseEntity<FlagRegroupementDTO> create(@Valid @RequestBody FlagRegroupementDTO dto) {
        FlagRegroupementDTO created = service.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FlagRegroupementDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlagRegroupementDTO> getById(@PathVariable Integer id) {
        Optional<FlagRegroupementDTO> flag = service.getById(id);
        return flag.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlagRegroupementDTO> update(@PathVariable Integer id, @Valid @RequestBody FlagRegroupementDTO dto) {
        FlagRegroupementDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}