package com.yparametrage.repository;

import com.yparametrage.entity.FlagRegroupement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FlagRegroupementRepository extends JpaRepository<FlagRegroupement, Integer> {
    Optional<FlagRegroupement> findByNom(String nom);
}