package me.dio.service;

import java.util.List;

import me.dio.domain.model.Feature;

public interface FeatureService {
    List<Feature> findAll();
    Feature findById(Long id);
    Feature create(Feature feature);
    Feature update(Long id, Feature feature);
    void delete(Long id);
} 