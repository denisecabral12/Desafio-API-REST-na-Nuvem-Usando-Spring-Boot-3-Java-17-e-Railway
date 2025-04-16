package me.dio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import me.dio.domain.model.Feature;
import me.dio.domain.repository.FeatureRepository;
import me.dio.service.FeatureService;
import me.dio.service.exception.NotFoundException;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public List<Feature> findAll() {
        return featureRepository.findAll();
    }

    @Override
    public Feature findById(Long id) {
        return featureRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Feature not found with ID: " + id));
    }

    @Override
    public Feature create(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public Feature update(Long id, Feature feature) {
        if (!featureRepository.existsById(id)) {
            throw new NotFoundException("Feature not found with ID: " + id);
        }
        feature.setId(id);
        return featureRepository.save(feature);
    }

    @Override
    public void delete(Long id) {
        if (!featureRepository.existsById(id)) {
            throw new NotFoundException("Feature not found with ID: " + id);
        }
        featureRepository.deleteById(id);
    }
} 