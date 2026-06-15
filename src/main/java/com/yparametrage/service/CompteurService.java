package com.yparametrage.service;

import com.yparametrage.dto.CompteurDTO;
import com.yparametrage.entity.Compteur;
import com.yparametrage.repository.CompteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompteurService {
    @Autowired
    private CompteurRepository compteurRepository;

    public CompteurDTO create(CompteurDTO dto) {
        Compteur compteur = mapDTOToEntity(dto);
        Compteur saved = compteurRepository.save(compteur);
        return mapToDTO(saved);
    }

    public List<CompteurDTO> getAll() {
        return compteurRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<CompteurDTO> getById(Integer id) {
        return compteurRepository.findById(id).map(this::mapToDTO);
    }

    public CompteurDTO update(Integer id, CompteurDTO dto) {
        Optional<Compteur> compteur = compteurRepository.findById(id);
        if (compteur.isPresent()) {
            Compteur entity = compteur.get();
            entity.setType(dto.getType());
            entity.setCode(dto.getCode());
            entity.setDeposant(dto.getDeposant());
            entity.setCommentaire(dto.getCommentaire());
            entity.setLoginModification(dto.getLoginModification());
            Compteur updated = compteurRepository.save(entity);
            return mapToDTO(updated);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (compteurRepository.existsById(id)) {
            compteurRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private CompteurDTO mapToDTO(Compteur compteur) {
        CompteurDTO dto = new CompteurDTO();
        dto.setId(compteur.getId());
        dto.setType(compteur.getType());
        dto.setCode(compteur.getCode());
        dto.setDeposant(compteur.getDeposant());
        dto.setCommentaire(compteur.getCommentaire());
        dto.setLoginCreation(compteur.getLoginCreation());
        dto.setLoginModification(compteur.getLoginModification());
        dto.setDateCreation(compteur.getDateCreation());
        dto.setDateModification(compteur.getDateModification());
        return dto;
    }

    private Compteur mapDTOToEntity(CompteurDTO dto) {
        Compteur compteur = new Compteur();
        compteur.setType(dto.getType());
        compteur.setCode(dto.getCode());
        compteur.setDeposant(dto.getDeposant());
        compteur.setCommentaire(dto.getCommentaire());
        compteur.setLoginCreation(dto.getLoginCreation());
        compteur.setLoginModification(dto.getLoginModification());
        return compteur;
    }
}