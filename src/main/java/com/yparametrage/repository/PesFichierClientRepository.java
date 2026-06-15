package com.yparametrage.repository;

import com.yparametrage.entity.PesFichierClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesFichierClientRepository extends JpaRepository<PesFichierClient, String> {
}