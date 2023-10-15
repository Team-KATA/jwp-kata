package com.kata.kata.domain.repository;

import com.kata.kata.domain.ArticleKeyword;
import com.kata.kata.domain.Sentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface SentimentRepository extends JpaRepository<Sentiment, Long> {

    default Sentiment get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
