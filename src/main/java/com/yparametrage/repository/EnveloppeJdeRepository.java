package com.yparametrage.repository;

import com.yparametrage.entity.EnveloppeJde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnveloppeJdeRepository extends JpaRepository<EnveloppeJde, Integer> {
}