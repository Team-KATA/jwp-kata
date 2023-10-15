package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ArticleSentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sentiment_id", nullable = false)
    private Sentiment sentiment;

    public ArticleSentiment(
            Long id,
            Article article,
            Sentiment sentiment
    ) {
        this.id = id;
        this.article = article;
        this.sentiment = sentiment;
    }

    public ArticleSentiment(
            Article article,
            Sentiment sentiment
    ) {
        this(null, article, sentiment);
    }
}
