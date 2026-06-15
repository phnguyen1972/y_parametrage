package com.yparametrage.service;

import com.yparametrage.dto.JdeDTO;
import com.yparametrage.entity.InsertJde;
import com.yparametrage.entity.SupportJde;
import com.yparametrage.entity.EnveloppeJde;
import com.yparametrage.repository.InsertJdeRepository;
import com.yparametrage.repository.SupportJdeRepository;
import com.yparametrage.repository.EnveloppeJdeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class JdeService {
    @Autowired
    private InsertJdeRepository insertJdeRepository;
    @Autowired
    private SupportJdeRepository supportJdeRepository;
    @Autowired
    private EnveloppeJdeRepository enveloppeJdeRepository;

    // InsertJde methods
    public JdeDTO createInsert(JdeDTO dto) {
        InsertJde insert = new InsertJde();
        insert.setLibelle(dto.getLibelle());
        insert.setReference(dto.getReference());
        insert.setPoids(dto.getPoids());
        insert.setDebutValidite(dto.getDebutValidite());
        insert.setFinValidite(dto.getFinValidite());
        InsertJde saved = insertJdeRepository.save(insert);
        return mapInsertToDTO(saved);
    }

    public List<JdeDTO> getAllInserts() {
        return insertJdeRepository.findAll().stream().map(this::mapInsertToDTO).collect(Collectors.toList());
    }

    public Optional<JdeDTO> getInsertById(Integer id) {
        return insertJdeRepository.findById(id).map(this::mapInsertToDTO);
    }

    public boolean deleteInsert(Integer id) {
        if (insertJdeRepository.existsById(id)) {
            insertJdeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // SupportJde methods
    public JdeDTO createSupport(JdeDTO dto) {
        SupportJde support = new SupportJde();
        support.setLibelle(dto.getLibelle());
        support.setReference(dto.getReference());
        support.setPoids(dto.getPoids());
        support.setDebutValidite(dto.getDebutValidite());
        support.setFinValidite(dto.getFinValidite());
        SupportJde saved = supportJdeRepository.save(support);
        return mapSupportToDTO(saved);
    }

    public List<JdeDTO> getAllSupports() {
        return supportJdeRepository.findAll().stream().map(this::mapSupportToDTO).collect(Collectors.toList());
    }

    public Optional<JdeDTO> getSupportById(Integer id) {
        return supportJdeRepository.findById(id).map(this::mapSupportToDTO);
    }

    public boolean deleteSupport(Integer id) {
        if (supportJdeRepository.existsById(id)) {
            supportJdeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // EnveloppeJde methods
    public JdeDTO createEnveloppe(JdeDTO dto) {
        EnveloppeJde enveloppe = new EnveloppeJde();
        enveloppe.setLibelle(dto.getLibelle());
        enveloppe.setFormat(dto.getFormat());
        enveloppe.setReference(dto.getReference());
        enveloppe.setPoids(dto.getPoids());
        enveloppe.setDebutValidite(dto.getDebutValidite());
        enveloppe.setFinValidite(dto.getFinValidite());
        EnveloppeJde saved = enveloppeJdeRepository.save(enveloppe);
        return mapEnveloppeToDTO(saved);
    }

    public List<JdeDTO> getAllEnveloppes() {
        return enveloppeJdeRepository.findAll().stream().map(this::mapEnveloppeToDTO).collect(Collectors.toList());
    }

    public Optional<JdeDTO> getEnveloppeById(Integer id) {
        return enveloppeJdeRepository.findById(id).map(this::mapEnveloppeToDTO);
    }

    public boolean deleteEnveloppe(Integer id) {
        if (enveloppeJdeRepository.existsById(id)) {
            enveloppeJdeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private JdeDTO mapInsertToDTO(InsertJde insert) {
        return new JdeDTO(insert.getId(), insert.getLibelle(), insert.getReference(), insert.getPoids(), null, insert.getDebutValidite(), insert.getFinValidite());
    }

    private JdeDTO mapSupportToDTO(SupportJde support) {
        return new JdeDTO(support.getId(), support.getLibelle(), support.getReference(), support.getPoids(), null, support.getDebutValidite(), support.getFinValidite());
    }

    private JdeDTO mapEnveloppeToDTO(EnveloppeJde enveloppe) {
        return new JdeDTO(enveloppe.getId(), enveloppe.getLibelle(), enveloppe.getReference(), enveloppe.getPoids(), enveloppe.getFormat(), enveloppe.getDebutValidite(), enveloppe.getFinValidite());
    }
}