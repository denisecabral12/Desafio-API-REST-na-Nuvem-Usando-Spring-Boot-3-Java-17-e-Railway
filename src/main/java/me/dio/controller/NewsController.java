package me.dio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.domain.model.News;
import me.dio.service.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<News>> findAll() {
        return ResponseEntity.ok(newsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> findById(@PathVariable Long id) {
        return ResponseEntity.ok(newsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<News> create(@RequestBody News news) {
        return ResponseEntity.ok(newsService.create(news));
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> update(@PathVariable Long id, @RequestBody News news) {
        return ResponseEntity.ok(newsService.update(id, news));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        newsService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 