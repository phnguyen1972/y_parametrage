package com.yparametrage.repository;

import com.yparametrage.entity.SupportJde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportJdeRepository extends JpaRepository<SupportJde, Integer> {
}