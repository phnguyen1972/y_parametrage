package com.yparametrage.controller;

import com.yparametrage.dto.CompteurDTO;
import com.yparametrage.service.CompteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compteur")
@CrossOrigin(origins = "*")
public class CompteurController {
    @Autowired
    private CompteurService compteurService;

    @PostMapping
    public ResponseEntity<CompteurDTO> create(@Valid @RequestBody CompteurDTO dto) {
        CompteurDTO created = compteurService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CompteurDTO>> getAll() {
        return ResponseEntity.ok(compteurService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompteurDTO> getById(@PathVariable Integer id) {
        Optional<CompteurDTO> compteur = compteurService.getById(id);
        return compteur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompteurDTO> update(@PathVariable Integer id, @Valid @RequestBody CompteurDTO dto) {
        CompteurDTO updated = compteurService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return compteurService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}