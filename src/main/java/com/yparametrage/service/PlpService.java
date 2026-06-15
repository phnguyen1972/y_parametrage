package com.yparametrage.service;

import com.yparametrage.dto.PlpDTO;
import com.yparametrage.entity.Plp;
import com.yparametrage.repository.PlpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlpService {
    @Autowired
    private PlpRepository plpRepository;

    public PlpDTO create(PlpDTO dto) {
        Plp plp = new Plp();
        plp.setPlpLibelle(dto.getPlpLibelle());
        plp.setTypeCompteur(dto.getTypeCompteur());
        plp.setRepOut(dto.getRepOut());
        plp.setPlpTop(dto.getPlpTop());
        plp.setCommentaire(dto.getCommentaire());
        Plp saved = plpRepository.save(plp);
        return mapToDTO(saved);
    }

    public List<PlpDTO> getAll() {
        return plpRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<PlpDTO> getById(Integer id) {
        return plpRepository.findById(id).map(this::mapToDTO);
    }

    public PlpDTO update(Integer id, PlpDTO dto) {
        Optional<Plp> plp = plpRepository.findById(id);
        if (plp.isPresent()) {
            Plp entity = plp.get();
            entity.setPlpLibelle(dto.getPlpLibelle());
            entity.setTypeCompteur(dto.getTypeCompteur());
            entity.setRepOut(dto.getRepOut());
            entity.setPlpTop(dto.getPlpTop());
            entity.setCommentaire(dto.getCommentaire());
            Plp updated = plpRepository.save(entity);
            return mapToDTO(updated);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (plpRepository.existsById(id)) {
            plpRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<PlpDTO> findByTypeCompteur(String typeCompteur) {
        return plpRepository.findByTypeCompteur(typeCompteur).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private PlpDTO mapToDTO(Plp plp) {
        return new PlpDTO(plp.getId(), plp.getPlpLibelle(), plp.getTypeCompteur(), plp.getRepOut(), plp.getPlpTop(), plp.getCommentaire(), plp.getDateCreation(), plp.getDateModification());
    }
}