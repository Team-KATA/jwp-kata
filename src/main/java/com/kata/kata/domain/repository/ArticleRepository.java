package com.kata.kata.domain.repository;

import com.kata.kata.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    default Article get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
