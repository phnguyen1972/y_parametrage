package com.yparametrage.controller;

import com.yparametrage.dto.PesFichierClientDTO;
import com.yparametrage.service.PesFichierClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pes-fichier-client")
@CrossOrigin(origins = "*")
public class PesFichierClientController {
    @Autowired
    private PesFichierClientService pesFichierClientService;

    @PostMapping
    public ResponseEntity<PesFichierClientDTO> create(@Valid @RequestBody PesFichierClientDTO dto) {
        return new ResponseEntity<>(pesFichierClientService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PesFichierClientDTO>> getAll() {
        return ResponseEntity.ok(pesFichierClientService.getAll());
    }

    @GetMapping("/{codeClient}")
    public ResponseEntity<PesFichierClientDTO> getById(@PathVariable String codeClient) {
        Optional<PesFichierClientDTO> pes = pesFichierClientService.getById(codeClient);
        return pes.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{codeClient}")
    public ResponseEntity<Void> delete(@PathVariable String codeClient) {
        return pesFichierClientService.delete(codeClient) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}