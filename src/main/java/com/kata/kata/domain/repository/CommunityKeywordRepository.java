package com.kata.kata.domain.repository;

import com.kata.kata.domain.CommunityKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;

public interface CommunityKeywordRepository extends JpaRepository<CommunityKeyword, Long> {

    default CommunityKeyword get(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
