package com.kata.kata.application.dto;

import com.kata.kata.domain.Trend;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TrendOpinionResponses {

    private LocalDateTime time;
    private List<TrendOpinionResponse> data;

    public TrendOpinionResponses(LocalDateTime time, List<TrendOpinionResponse> data) {
        this.time = time;
        this.data = data;
    }

    public static TrendOpinionResponses of(Trend trend, List<TrendOpinionResponse> responses) {
        return new TrendOpinionResponses(trend.getTime(), responses);
    }
}
