package com.kata.kata.presentation;

import com.kata.kata.application.TrendService;
import com.kata.kata.application.dto.TrendKeywordResponses;
import com.kata.kata.application.dto.TrendOpinionResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/trends")
public class TrendController {

    private final TrendService trendService;

    @GetMapping("/keywords")
    public ResponseEntity<TrendKeywordResponses> findKeywordsByTrend(@RequestParam("time") LocalDateTime time) {
        return ResponseEntity.ok(trendService.findTrendKeywords(time));
    }

    @GetMapping("/opinions")
    public ResponseEntity<TrendOpinionResponses> findOpinionsByTrend(@RequestParam("time") LocalDateTime time) {
        return ResponseEntity.ok(trendService.findTrendOpinions(time));
    }
}
