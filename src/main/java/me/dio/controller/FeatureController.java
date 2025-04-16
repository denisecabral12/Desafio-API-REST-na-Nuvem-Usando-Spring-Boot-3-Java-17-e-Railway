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

import me.dio.domain.model.Feature;
import me.dio.service.FeatureService;

@RestController
@RequestMapping("/features")
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping
    public ResponseEntity<List<Feature>> findAll() {
        return ResponseEntity.ok(featureService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> findById(@PathVariable Long id) {
        return ResponseEntity.ok(featureService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Feature> create(@RequestBody Feature feature) {
        return ResponseEntity.ok(featureService.create(feature));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feature> update(@PathVariable Long id, @RequestBody Feature feature) {
        return ResponseEntity.ok(featureService.update(id, feature));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        featureService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 