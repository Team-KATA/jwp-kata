package com.kata.kata.application;

import com.kata.kata.application.dto.TrendKeywordResponse;
import com.kata.kata.application.dto.TrendKeywordResponses;
import com.kata.kata.application.dto.TrendOpinionResponse;
import com.kata.kata.application.dto.TrendOpinionResponses;
import com.kata.kata.domain.Trend;
import com.kata.kata.domain.TrendKeyword;
import com.kata.kata.domain.TrendOpinion;
import com.kata.kata.domain.repository.TrendKeywordRepository;
import com.kata.kata.domain.repository.TrendOpinionRepository;
import com.kata.kata.domain.repository.TrendRepository;
import com.kata.kata.fixture.HitsFixture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class TrendService {

    private final TrendRepository trendRepository;
    private final TrendKeywordRepository trendKeywordRepository;
    private final TrendOpinionRepository trendOpinionRepository;

    @Transactional(readOnly = true)
    public TrendKeywordResponses findTrendKeywords(LocalDateTime time) {
        Trend trend = trendRepository.findByTime(time);
        List<TrendKeyword> trendKeywords = trendKeywordRepository.findAllByTrend(trend);
        return TrendKeywordResponses.of(trend, trendKeywords.stream()
                .map(it -> TrendKeywordResponse.of(it, HitsFixture.HUNDRED_HITS))
                .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public TrendOpinionResponses findTrendOpinions(LocalDateTime time) {
        Trend trend = trendRepository.findByTime(time);
        List<TrendOpinion> trendOpinions = trendOpinionRepository.findByTrend(trend);
        return TrendOpinionResponses.of(trend, trendOpinions.stream()
                .map(TrendOpinionResponse::of)
                .collect(Collectors.toList()));
    }
}
