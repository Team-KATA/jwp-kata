package com.kata.kata.application.dto;

import com.kata.kata.domain.Trend;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TrendHitsResponses {

    private LocalDateTime time;
    private List<TrendHitsResponse> data;

    public TrendHitsResponses(LocalDateTime time, List<TrendHitsResponse> data) {
        this.time = time;
        this.data = data;
    }

    public static TrendHitsResponses of(Trend trend, List<TrendHitsResponse> responses) {
        return new TrendHitsResponses(trend.getTime(), responses);
    }
}
