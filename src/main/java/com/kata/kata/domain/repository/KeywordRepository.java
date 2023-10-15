package com.kata.kata.domain.repository;

import com.kata.kata.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    default Keyword get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
