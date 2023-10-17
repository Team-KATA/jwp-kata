package com.kata.kata.domain.repository;

import com.kata.kata.domain.Trend;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

public interface TrendRepository extends JpaRepository<Trend, Long> {

    Trend findByTime(LocalDateTime time);

    default Trend get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
