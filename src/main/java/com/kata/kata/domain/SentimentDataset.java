package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SentimentDataset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sentiment_id", nullable = false)
    private Sentiment sentiment;

    @Column(name = "sentence", nullable = false)
    private String sentence;

    public SentimentDataset(
            Long id,
            Sentiment sentiment,
            String sentence
    ) {
        this.id = id;
        this.sentiment = sentiment;
        this.sentence = sentence;
    }

    public SentimentDataset(
            Sentiment sentiment,
            String sentence
    ) {
        this(null, sentiment, sentence);
    }
}
