package com.yparametrage.service;

import com.yparametrage.dto.AffectationApplicationDTO;
import com.yparametrage.entity.AffectationApplication;
import com.yparametrage.entity.Plp;
import com.yparametrage.repository.AffectationApplicationRepository;
import com.yparametrage.repository.PlpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AffectationApplicationService {
    @Autowired
    private AffectationApplicationRepository affectationApplicationRepository;
    @Autowired
    private PlpRepository plpRepository;

    public AffectationApplicationDTO create(AffectationApplicationDTO dto) {
        Optional<Plp> plp = plpRepository.findById(dto.getPlpId());
        if (plp.isPresent()) {
            AffectationApplication affectation = new AffectationApplication();
            affectation.setPlp(plp.get());
            affectation.setCodeAppli(dto.getCodeAppli());
            affectation.setCodeClientOrigine(dto.getCodeClientOrigine());
            affectation.setApa(dto.getApa());
            AffectationApplication saved = affectationApplicationRepository.save(affectation);
            return mapToDTO(saved);
        }
        return null;
    }

    public List<AffectationApplicationDTO> getAll() {
        return affectationApplicationRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<AffectationApplicationDTO> getById(Integer id) {
        return affectationApplicationRepository.findById(id).map(this::mapToDTO);
    }

    public AffectationApplicationDTO update(Integer id, AffectationApplicationDTO dto) {
        Optional<AffectationApplication> affectation = affectationApplicationRepository.findById(id);
        if (affectation.isPresent()) {
            AffectationApplication entity = affectation.get();
            entity.setCodeAppli(dto.getCodeAppli());
            entity.setCodeClientOrigine(dto.getCodeClientOrigine());
            entity.setApa(dto.getApa());
            AffectationApplication updated = affectationApplicationRepository.save(entity);
            return mapToDTO(updated);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (affectationApplicationRepository.existsById(id)) {
            affectationApplicationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<AffectationApplicationDTO> findByPlpId(Integer plpId) {
        return affectationApplicationRepository.findByPlpId(plpId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private AffectationApplicationDTO mapToDTO(AffectationApplication affectation) {
        return new AffectationApplicationDTO(affectation.getId(), affectation.getPlp().getId(), affectation.getCodeAppli(), affectation.getCodeClientOrigine(), affectation.getApa(), affectation.getDateCreation(), affectation.getDateModification());
    }
}