package com.kata.kata.domain.repository;

import com.kata.kata.domain.TrendOpinion;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface TrendOpinionRepository extends JpaRepository<TrendOpinion, Long> {

    default TrendOpinion get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
