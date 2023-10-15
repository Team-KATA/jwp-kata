package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TrendOpinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trend_id", nullable = false)
    private Trend trend;

    @Column(name = "opinion", nullable = false)
    private float opinion;

    @Column(name = "hits", nullable = false)
    private int hits;

    public TrendOpinion(
            Long id,
            Trend trend,
            Float opinion,
            Integer hits
    ) {
        this.id = id;
        this.trend = trend;
        this.opinion = opinion;
        this.hits = hits;
    }

    public TrendOpinion(
            Trend trend,
            Float opinion,
            Integer hits
    ) {
        this(null, trend, opinion, hits);
    }
}
