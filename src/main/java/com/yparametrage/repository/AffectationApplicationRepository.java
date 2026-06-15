package com.yparametrage.repository;

import com.yparametrage.entity.AffectationApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AffectationApplicationRepository extends JpaRepository<AffectationApplication, Integer> {
    List<AffectationApplication> findByPlpId(Integer plpId);
}