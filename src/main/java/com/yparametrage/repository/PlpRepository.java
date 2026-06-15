package com.yparametrage.repository;

import com.yparametrage.entity.Plp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlpRepository extends JpaRepository<Plp, Integer> {
    List<Plp> findByTypeCompteur(String typeCompteur);
    List<Plp> findByRepOut(String repOut);
}