package com.yparametrage.service;

import com.yparametrage.dto.FlagRegroupementDTO;
import com.yparametrage.entity.FlagRegroupement;
import com.yparametrage.repository.FlagRegroupementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlagRegroupementService {
    @Autowired
    private FlagRegroupementRepository flagRegroupementRepository;

    public FlagRegroupementDTO create(FlagRegroupementDTO dto) {
        FlagRegroupement flag = new FlagRegroupement();
        flag.setNom(dto.getNom());
        flag.setLibelle(dto.getLibelle());
        FlagRegroupement saved = flagRegroupementRepository.save(flag);
        return mapToDTO(saved);
    }

    public List<FlagRegroupementDTO> getAll() {
        return flagRegroupementRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<FlagRegroupementDTO> getById(Integer id) {
        return flagRegroupementRepository.findById(id).map(this::mapToDTO);
    }

    public FlagRegroupementDTO update(Integer id, FlagRegroupementDTO dto) {
        Optional<FlagRegroupement> flag = flagRegroupementRepository.findById(id);
        if (flag.isPresent()) {
            FlagRegroupement entity = flag.get();
            entity.setNom(dto.getNom());
            entity.setLibelle(dto.getLibelle());
            FlagRegroupement updated = flagRegroupementRepository.save(entity);
            return mapToDTO(updated);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (flagRegroupementRepository.existsById(id)) {
            flagRegroupementRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private FlagRegroupementDTO mapToDTO(FlagRegroupement flag) {
        return new FlagRegroupementDTO(flag.getId(), flag.getNom(), flag.getLibelle());
    }
}