package com.yparametrage.controller;

import com.yparametrage.dto.PlpDTO;
import com.yparametrage.service.PlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plp")
@CrossOrigin(origins = "*")
public class PlpController {
    @Autowired
    private PlpService plpService;

    @PostMapping
    public ResponseEntity<PlpDTO> create(@Valid @RequestBody PlpDTO dto) {
        PlpDTO created = plpService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlpDTO>> getAll() {
        return ResponseEntity.ok(plpService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlpDTO> getById(@PathVariable Integer id) {
        Optional<PlpDTO> plp = plpService.getById(id);
        return plp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlpDTO> update(@PathVariable Integer id, @Valid @RequestBody PlpDTO dto) {
        PlpDTO updated = plpService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return plpService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/type/{typeCompteur}")
    public ResponseEntity<List<PlpDTO>> findByTypeCompteur(@PathVariable String typeCompteur) {
        return ResponseEntity.ok(plpService.findByTypeCompteur(typeCompteur));
    }
}