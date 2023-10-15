package com.kata.kata.domain.repository;

import com.kata.kata.domain.ArticleKeyword;
import com.kata.kata.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface ArticleKeywordRepository extends JpaRepository<ArticleKeyword, Long> {

    List<ArticleKeyword> findByKeyword(Keyword keyword);

    default ArticleKeyword get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
