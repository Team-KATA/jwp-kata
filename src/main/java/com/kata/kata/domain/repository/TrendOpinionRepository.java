package com.kata.kata.domain.repository;

import com.kata.kata.domain.TrendOpinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

public interface TrendOpinionRepository extends JpaRepository<TrendOpinion, Long> {

    default TrendOpinion get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Query("select t from TrendOpinion t where t.trend.time >= :time")
    List<TrendOpinion> findALLByTime(LocalDateTime time);
}
