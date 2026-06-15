package com.yparametrage.repository;

import com.yparametrage.entity.EnveloppeAutorisee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnveloppeAutoriseeRepository extends JpaRepository<EnveloppeAutorisee, Integer> {
    List<EnveloppeAutorisee> findByPlpId(Integer plpId);
}