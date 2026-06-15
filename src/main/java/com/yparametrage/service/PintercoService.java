package com.yparametrage.service;

import com.yparametrage.dto.PintercoDTO;
import com.yparametrage.entity.Pinterco;
import com.yparametrage.repository.PintercoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PintercoService {
    @Autowired
    private PintercoRepository pintercoRepository;

    public PintercoDTO create(PintercoDTO dto) {
        Pinterco pinterco = new Pinterco();
        pinterco.setIdf(dto.getIdf());
        pinterco.setPartenaire(dto.getPartenaire());
        pinterco.setCodeClient(dto.getCodeClient());
        pinterco.setCodeAppliClient(dto.getCodeAppliClient());
        pinterco.setDelaiConservationFichier(dto.getDelaiConservationFichier());
        pinterco.setWorkflowYeti(dto.getWorkflowYeti());
        Pinterco saved = pintercoRepository.save(pinterco);
        return mapToDTO(saved);
    }

    public List<PintercoDTO> getAll() {
        return pintercoRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<PintercoDTO> getById(String idf) {
        return pintercoRepository.findById(idf).map(this::mapToDTO);
    }

    public boolean delete(String idf) {
        if (pintercoRepository.existsById(idf)) {
            pintercoRepository.deleteById(idf);
            return true;
        }
        return false;
    }

    private PintercoDTO mapToDTO(Pinterco pinterco) {
        return new PintercoDTO(pinterco.getIdf(), pinterco.getPartenaire(), pinterco.getCodeClient(), pinterco.getCodeAppliClient(), pinterco.getDelaiConservationFichier(), pinterco.getWorkflowYeti());
    }
}