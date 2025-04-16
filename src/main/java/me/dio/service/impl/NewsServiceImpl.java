package me.dio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import me.dio.domain.model.News;
import me.dio.domain.repository.NewsRepository;
import me.dio.service.NewsService;
import me.dio.service.exception.NotFoundException;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public News findById(Long id) {
        return newsRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("News not found with ID: " + id));
    }

    @Override
    public News create(News news) {
        return newsRepository.save(news);
    }

    @Override
    public News update(Long id, News news) {
        if (!newsRepository.existsById(id)) {
            throw new NotFoundException("News not found with ID: " + id);
        }
        news.setId(id);
        return newsRepository.save(news);
    }

    @Override
    public void delete(Long id) {
        if (!newsRepository.existsById(id)) {
            throw new NotFoundException("News not found with ID: " + id);
        }
        newsRepository.deleteById(id);
    }
} 