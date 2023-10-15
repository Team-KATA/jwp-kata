package com.kata.kata.presentation;

import com.kata.kata.application.KeywordService;
import com.kata.kata.application.dto.ArticleKeywordResponse;
import com.kata.kata.application.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/keywords")
public class KeywordController {

    private final KeywordService keywordService;

    @GetMapping("/{keywordId}/articles")
    public ResponseEntity<Response<ArticleKeywordResponse>> findArticlesByKeyword(@PathVariable("keywordId") Long id) {
        return ResponseEntity.ok(Response.of(keywordService.findArticleKeywords(id)));
    }
}
