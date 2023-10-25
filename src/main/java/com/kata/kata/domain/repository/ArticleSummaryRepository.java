package com.kata.kata.domain.repository;

import com.kata.kata.domain.Article;
import com.kata.kata.domain.ArticleSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface ArticleSummaryRepository extends JpaRepository<ArticleSummary, Long> {

    ArticleSummary findByArticle(Article article);
  
    default ArticleSummary get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
