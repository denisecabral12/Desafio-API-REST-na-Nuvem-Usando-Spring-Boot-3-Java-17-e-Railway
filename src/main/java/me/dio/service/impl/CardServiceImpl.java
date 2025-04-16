package me.dio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import me.dio.domain.model.Card;
import me.dio.domain.repository.CardRepository;
import me.dio.service.CardService;
import me.dio.service.exception.NotFoundException;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card findById(Long id) {
        return cardRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Card not found with ID: " + id));
    }

    @Override
    public Card create(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card update(Long id, Card card) {
        if (!cardRepository.existsById(id)) {
            throw new NotFoundException("Card not found with ID: " + id);
        }
        card.setId(id);
        return cardRepository.save(card);
    }

    @Override
    public void delete(Long id) {
        if (!cardRepository.existsById(id)) {
            throw new NotFoundException("Card not found with ID: " + id);
        }
        cardRepository.deleteById(id);
    }
} 