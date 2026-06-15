package com.yparametrage.service;

import com.yparametrage.dto.EnveloppeAutoriseeDTO;
import com.yparametrage.entity.EnveloppeAutorisee;
import com.yparametrage.entity.Plp;
import com.yparametrage.repository.EnveloppeAutoriseeRepository;
import com.yparametrage.repository.PlpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnveloppeAutoriseeService {
    @Autowired
    private EnveloppeAutoriseeRepository enveloppeAutoriseeRepository;
    @Autowired
    private PlpRepository plpRepository;

    public EnveloppeAutoriseeDTO create(EnveloppeAutoriseeDTO dto) {
        Optional<Plp> plp = plpRepository.findById(dto.getPlpId());
        if (plp.isPresent()) {
            EnveloppeAutorisee enveloppe = new EnveloppeAutorisee();
            enveloppe.setPlp(plp.get());
            enveloppe.setCodePays(EnveloppeAutorisee.CodePays.valueOf(dto.getCodePays()));
            enveloppe.setFormat(dto.getFormat());
            enveloppe.setPoidsMin(dto.getPoidsMin());
            enveloppe.setPoidsMax(dto.getPoidsMax());
            EnveloppeAutorisee saved = enveloppeAutoriseeRepository.save(enveloppe);
            return mapToDTO(saved);
        }
        return null;
    }

    public List<EnveloppeAutoriseeDTO> getAll() {
        return enveloppeAutoriseeRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Optional<EnveloppeAutoriseeDTO> getById(Integer id) {
        return enveloppeAutoriseeRepository.findById(id).map(this::mapToDTO);
    }

    public EnveloppeAutoriseeDTO update(Integer id, EnveloppeAutoriseeDTO dto) {
        Optional<EnveloppeAutorisee> enveloppe = enveloppeAutoriseeRepository.findById(id);
        if (enveloppe.isPresent()) {
            EnveloppeAutorisee entity = enveloppe.get();
            entity.setCodePays(EnveloppeAutorisee.CodePays.valueOf(dto.getCodePays()));
            entity.setFormat(dto.getFormat());
            entity.setPoidsMin(dto.getPoidsMin());
            entity.setPoidsMax(dto.getPoidsMax());
            EnveloppeAutorisee updated = enveloppeAutoriseeRepository.save(entity);
            return mapToDTO(updated);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (enveloppeAutoriseeRepository.existsById(id)) {
            enveloppeAutoriseeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<EnveloppeAutoriseeDTO> findByPlpId(Integer plpId) {
        return enveloppeAutoriseeRepository.findByPlpId(plpId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private EnveloppeAutoriseeDTO mapToDTO(EnveloppeAutorisee enveloppe) {
        return new EnveloppeAutoriseeDTO(enveloppe.getId(), enveloppe.getPlp().getId(), enveloppe.getCodePays().name(), enveloppe.getFormat(), enveloppe.getPoidsMin(), enveloppe.getPoidsMax());
    }
}