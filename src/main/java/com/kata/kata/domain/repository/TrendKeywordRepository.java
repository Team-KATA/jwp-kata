package com.kata.kata.domain.repository;

import com.kata.kata.domain.Trend;
import com.kata.kata.domain.TrendKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface TrendKeywordRepository extends JpaRepository<TrendKeyword, Long> {

    List<TrendKeyword> findAllByTrend(Trend trend);

    default TrendKeyword get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
