package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CommunitySentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id", nullable = false)
    private Community community;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sentiment_id", nullable = false)
    private Sentiment sentiment;

    public CommunitySentiment(
            Long id,
            Community community,
            Sentiment sentiment
    ) {
        this.id = id;
        this.community = community;
        this.sentiment = sentiment;
    }

    public CommunitySentiment(
            Community community,
            Sentiment sentiment
    ) {
        this(null, community, sentiment);
    }
}
