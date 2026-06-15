package com.yparametrage.repository;

import com.yparametrage.entity.TopDiag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopDiagRepository extends JpaRepository<TopDiag, Integer> {
}