package com.example.orientationexamretake.services;

import com.example.orientationexamretake.models.Attraction;
import com.example.orientationexamretake.models.Category;
import com.example.orientationexamretake.repositories.AttractionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttractionService {

    AttractionRepository attractionRepository;


    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public void save(Attraction attraction) {
        attractionRepository.save(attraction);
    }

    public List<Attraction> findAll() {
        return attractionRepository.findAll();
    }

    public Optional<Attraction> findById(Long id) {
        return attractionRepository.findById(id);
    }

    public List<Attraction> findAttractionsByCategory(Category category) {
        return attractionRepository.findAttractionByCategory(category);
    }

    public Attraction findCheapestAttraction(List<Attraction> list) {
        Attraction cheapestAttraction = new Attraction();
        for (Attraction attraction : list) {
            if (attraction.getPrice() < cheapestAttraction.getPrice()) {
                cheapestAttraction = attraction;
            }
        }
        return cheapestAttraction;
    }
}
