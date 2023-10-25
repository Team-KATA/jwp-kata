package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ArticleSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @Column(name = "body", nullable = false)
    private String body;

    public ArticleSummary(
            Long id,
            Article article,
            String body
    ) {
        this.id = id;
        this.article = article;
        this.body = body;
    }

    public ArticleSummary(
            Article article,
            String body
    ) {
        this(null, article, body);
    }
}
