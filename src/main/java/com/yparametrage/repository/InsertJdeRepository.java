package com.yparametrage.repository;

import com.yparametrage.entity.InsertJde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsertJdeRepository extends JpaRepository<InsertJde, Integer> {
}