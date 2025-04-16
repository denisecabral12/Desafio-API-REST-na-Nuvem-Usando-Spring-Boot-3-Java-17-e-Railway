package me.dio.service;

import java.util.List;

import me.dio.domain.model.News;

public interface NewsService {
    List<News> findAll();
    News findById(Long id);
    News create(News news);
    News update(Long id, News news);
    void delete(Long id);
} 