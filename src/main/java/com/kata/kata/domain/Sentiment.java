package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Sentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hashtag", nullable = false)
    private String hashtag;

    public Sentiment(
            Long id,
            String hashtag
    ) {
        this.id = id;
        this.hashtag = hashtag;
    }
}
