package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CommunityKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id", nullable = false)
    private Community community;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyword_id", nullable = false)
    private Keyword keyword;

    public CommunityKeyword(
            Long id,
            Community community,
            Keyword keyword
    ) {
        this.id = id;
        this.community = community;
        this.keyword = keyword;
    }

    public CommunityKeyword(
            Community community,
            Keyword keyword
    ) {
        this(null, community, keyword);
    }
}
