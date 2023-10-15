package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ArticleKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyword_id", nullable = false)
    private Keyword keyword;

    public ArticleKeyword(
            Long id,
            Article article,
            Keyword keyword
    ) {
        this.id = id;
        this.article = article;
        this.keyword = keyword;
    }

    public ArticleKeyword(
            Article article,
            Keyword keyword
    ) {
        this(null, article, keyword);
    }
}
