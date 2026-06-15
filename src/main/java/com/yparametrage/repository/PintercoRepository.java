package com.yparametrage.repository;

import com.yparametrage.entity.Pinterco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PintercoRepository extends JpaRepository<Pinterco, String> {
}