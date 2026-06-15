package com.yparametrage.service;

import com.yparametrage.dto.TopDiagDTO;
import com.yparametrage.entity.TopDiag;
import com.yparametrage.entity.Plp;
import com.yparametrage.repository.TopDiagRepository;
import com.yparametrage.repository.PlpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TopDiagService {
    @Autowired
    private TopDiagRepository topDiagRepository;
    @Autowired
    private PlpRepository plpRepository;

    public TopDiagDTO create(TopDiagDTO dto) {
        Optional<Plp> plp = plpRepository.findById(dto.getPlpId());
        if (plp.isPresent()) {
            TopDiag topDiag = new TopDiag();
            topDiag.setId(dto.getId());
            topDiag.setPlp(plp.get());
            topDiag.setTopArchiver(dto.getTopArchiver());
            topDiag.setTopNettoyer(dto.getTopNettoyer());
            topDiag.setTopNettoyerManu(dto.getTopNettoyerManu());
            topDiag.setTopChangerDateLiberation(dto.getTopChangerDateLiberation());
            topDiag.setTopCalculerTachesPlanifiees(dto.getTopCalculerTachesPlanifiees());
            topDiag.setTopIntegrer(dto.getTopIntegrer());
            topDiag.setTopRegrouper(dto.getTopRegrouper());
            topDiag.setTopLiberer(dto.getTopLiberer());
            topDiag.setTopExtraire(dto.getTopExtraire());
            topDiag.setTopMassifier(dto.getTopMassifier());
            TopDiag saved = topDiagRepository.save(topDiag);
            return mapToDTO(saved);
        }
        return null;
    }

    public List<TopDiagDTO> getAll() {
        return topDiagRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<TopDiagDTO> getById(Integer id) {
        return topDiagRepository.findById(id).map(this::mapToDTO);
    }

    public TopDiagDTO update(Integer id, TopDiagDTO dto) {
        Optional<TopDiag> topDiag = topDiagRepository.findById(id);
        if (topDiag.isPresent()) {
            TopDiag entity = topDiag.get();
            entity.setTopArchiver(dto.getTopArchiver());
            entity.setTopNettoyer(dto.getTopNettoyer());
            entity.setTopNettoyerManu(dto.getTopNettoyerManu());
            entity.setTopChangerDateLiberation(dto.getTopChangerDateLiberation());
            entity.setTopCalculerTachesPlanifiees(dto.getTopCalculerTachesPlanifiees());
            entity.setTopIntegrer(dto.getTopIntegrer());
            entity.setTopRegrouper(dto.getTopRegrouper());
            entity.setTopLiberer(dto.getTopLiberer());
            entity.setTopExtraire(dto.getTopExtraire());
            entity.setTopMassifier(dto.getTopMassifier());
            TopDiag updated = topDiagRepository.save(entity);
            return mapToDTO(updated);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (topDiagRepository.existsById(id)) {
            topDiagRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private TopDiagDTO mapToDTO(TopDiag topDiag) {
        return new TopDiagDTO(topDiag.getId(), topDiag.getPlp().getId(), topDiag.getTopArchiver(), topDiag.getTopNettoyer(), topDiag.getTopNettoyerManu(), topDiag.getTopChangerDateLiberation(), topDiag.getTopCalculerTachesPlanifiees(), topDiag.getTopIntegrer(), topDiag.getTopRegrouper(), topDiag.getTopLiberer(), topDiag.getTopExtraire(), topDiag.getTopMassifier());
    }
}