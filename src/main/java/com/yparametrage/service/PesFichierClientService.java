package com.yparametrage.service;

import com.yparametrage.dto.PesFichierClientDTO;
import com.yparametrage.entity.PesFichierClient;
import com.yparametrage.repository.PesFichierClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PesFichierClientService {
    @Autowired
    private PesFichierClientRepository pesFichierClientRepository;

    public PesFichierClientDTO create(PesFichierClientDTO dto) {
        PesFichierClient pes = new PesFichierClient();
        pes.setCodeClient(dto.getCodeClient());
        pes.setCodeAppliClient(dto.getCodeAppliClient());
        pes.setEs(dto.getEs());
        pes.setSeuil(dto.getSeuil());
        pes.setUnite(dto.getUnite());
        pes.setHeureLimiteReception(dto.getHeureLimiteReception());
        PesFichierClient saved = pesFichierClientRepository.save(pes);
        return mapToDTO(saved);
    }

    public List<PesFichierClientDTO> getAll() {
        return pesFichierClientRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<PesFichierClientDTO> getById(String codeClient) {
        return pesFichierClientRepository.findById(codeClient).map(this::mapToDTO);
    }

    public boolean delete(String codeClient) {
        if (pesFichierClientRepository.existsById(codeClient)) {
            pesFichierClientRepository.deleteById(codeClient);
            return true;
        }
        return false;
    }

    private PesFichierClientDTO mapToDTO(PesFichierClient pes) {
        return new PesFichierClientDTO(pes.getCodeClient(), pes.getCodeAppliClient(), pes.getEs(), pes.getSeuil(), pes.getUnite(), pes.getHeureLimiteReception());
    }
}