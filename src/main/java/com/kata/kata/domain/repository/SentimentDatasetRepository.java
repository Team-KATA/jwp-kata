package com.kata.kata.domain.repository;

import com.kata.kata.domain.ArticleKeyword;
import com.kata.kata.domain.SentimentDataset;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface SentimentDatasetRepository extends JpaRepository<SentimentDataset, Long> {

    default SentimentDataset get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
