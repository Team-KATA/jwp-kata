package com.kata.kata.domain.repository;

import com.kata.kata.domain.Keyword;
import com.kata.kata.domain.Trend;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface TrendRepository extends JpaRepository<Trend, Long> {

    default Trend get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
