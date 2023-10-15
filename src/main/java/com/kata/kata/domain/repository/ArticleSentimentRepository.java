package com.kata.kata.domain.repository;

import com.kata.kata.domain.Article;
import com.kata.kata.domain.ArticleSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface ArticleSentimentRepository extends JpaRepository<ArticleSentiment, Long> {

    List<ArticleSentiment> findAllByArticle(Article article);

    default ArticleSentiment get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
