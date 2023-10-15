package com.kata.kata.domain.repository;

import com.kata.kata.domain.ArticleKeyword;
import com.kata.kata.domain.ArticleSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface ArticleSentimentRepository extends JpaRepository<ArticleSentiment, Long> {

    default ArticleSentiment get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
