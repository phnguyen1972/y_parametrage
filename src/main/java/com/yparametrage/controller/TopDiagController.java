package com.yparametrage.controller;

import com.yparametrage.dto.TopDiagDTO;
import com.yparametrage.service.TopDiagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/top-diag")
@CrossOrigin(origins = "*")
public class TopDiagController {
    @Autowired
    private TopDiagService topDiagService;

    @PostMapping
    public ResponseEntity<TopDiagDTO> create(@Valid @RequestBody TopDiagDTO dto) {
        TopDiagDTO created = topDiagService.create(dto);
        return created != null ? new ResponseEntity<>(created, HttpStatus.CREATED) : ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<TopDiagDTO>> getAll() {
        return ResponseEntity.ok(topDiagService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopDiagDTO> getById(@PathVariable Integer id) {
        Optional<TopDiagDTO> topDiag = topDiagService.getById(id);
        return topDiag.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopDiagDTO> update(@PathVariable Integer id, @Valid @RequestBody TopDiagDTO dto) {
        TopDiagDTO updated = topDiagService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return topDiagService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}