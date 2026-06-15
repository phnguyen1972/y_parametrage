package com.yparametrage.controller;

import com.yparametrage.dto.PintercoDTO;
import com.yparametrage.service.PintercoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pinterco")
@CrossOrigin(origins = "*")
public class PintercoController {
    @Autowired
    private PintercoService pintercoService;

    @PostMapping
    public ResponseEntity<PintercoDTO> create(@Valid @RequestBody PintercoDTO dto) {
        return new ResponseEntity<>(pintercoService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PintercoDTO>> getAll() {
        return ResponseEntity.ok(pintercoService.getAll());
    }

    @GetMapping("/{idf}")
    public ResponseEntity<PintercoDTO> getById(@PathVariable String idf) {
        Optional<PintercoDTO> pinterco = pintercoService.getById(idf);
        return pinterco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idf}")
    public ResponseEntity<Void> delete(@PathVariable String idf) {
        return pintercoService.delete(idf) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}