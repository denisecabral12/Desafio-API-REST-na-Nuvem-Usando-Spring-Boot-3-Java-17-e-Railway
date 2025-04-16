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

import me.dio.domain.model.Card;
import me.dio.service.CardService;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public ResponseEntity<List<Card>> findAll() {
        return ResponseEntity.ok(cardService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Card> create(@RequestBody Card card) {
        return ResponseEntity.ok(cardService.create(card));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@PathVariable Long id, @RequestBody Card card) {
        return ResponseEntity.ok(cardService.update(id, card));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cardService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 