package com.kata.kata.presentation;

import com.kata.kata.application.ArticleService;
import com.kata.kata.application.dto.ArticleResponse;
import com.kata.kata.application.dto.Response;
import com.kata.kata.application.dto.Responses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/{articleId}")
    public ResponseEntity<Response<ArticleResponse>> findArticle(@PathVariable("articleId") Long id) {
        return ResponseEntity.ok(Response.of(articleService.findArticle(id)));
    }

    @GetMapping
    public ResponseEntity<Responses<ArticleResponse>> findAllArticle() {
        return ResponseEntity.ok(Responses.of(articleService.findAllArticle()));
    }
}
