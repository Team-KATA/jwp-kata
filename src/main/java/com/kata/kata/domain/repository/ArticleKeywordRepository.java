package com.kata.kata.domain.repository;

import com.kata.kata.domain.Article;
import com.kata.kata.domain.ArticleKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface ArticleKeywordRepository extends JpaRepository<ArticleKeyword, Long> {

    default ArticleKeyword get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
