package me.dio.service;

import java.util.List;

import me.dio.domain.model.Card;

public interface CardService {
    List<Card> findAll();
    Card findById(Long id);
    Card create(Card card);
    Card update(Long id, Card card);
    void delete(Long id);
} 