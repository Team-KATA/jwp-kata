package com.kata.kata.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TrendKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyword_id", nullable = false)
    private Keyword keyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trend_id", nullable = false)
    private Trend trend;

    @Column(name = "ranking", nullable = false)
    private int ranking;

    public TrendKeyword(
            Long id,
            Keyword keyword,
            Trend trend,
            Integer ranking
    ) {
        this.id = id;
        this.keyword = keyword;
        this.trend = trend;
        this.ranking = ranking;
    }

    public TrendKeyword(
            Keyword keyword,
            Trend trend,
            Integer ranking
    ) {
        this(null, keyword, trend, ranking);
    }
}
