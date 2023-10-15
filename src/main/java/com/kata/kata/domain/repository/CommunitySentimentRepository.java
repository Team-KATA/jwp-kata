package com.kata.kata.domain.repository;

import com.kata.kata.domain.ArticleSentiment;
import com.kata.kata.domain.CommunitySentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface CommunitySentimentRepository extends JpaRepository<CommunitySentiment, Long> {

    default CommunitySentiment get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
