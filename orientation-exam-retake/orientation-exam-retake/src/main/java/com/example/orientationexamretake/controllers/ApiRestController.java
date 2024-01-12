package com.example.orientationexamretake.controllers;

import com.example.orientationexamretake.DTOs.AttractionAddDTO;
import com.example.orientationexamretake.models.Attraction;
import com.example.orientationexamretake.services.AttractionService;
import com.example.orientationexamretake.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    AttractionService attractionService;
    CategoryService categoryService;

    public ApiRestController(AttractionService attractionService, CategoryService categoryService) {
        this.attractionService = attractionService;
        this.categoryService = categoryService;
    }

    @PostMapping("/attractions")
    public ResponseEntity<?> saveAttraction(@RequestBody AttractionAddDTO attractionAddDTO) {
        if (attractionAddDTO.price() > 0 && attractionAddDTO.duration() > 0 && attractionAddDTO.recommendedAge() > 0
                && attractionAddDTO.longitude() % 1 != 0 && attractionAddDTO.latitude() % 1 != 0
                && categoryService.findByName(attractionAddDTO.category()) != null) {

            Attraction newAttraction = new Attraction(attractionAddDTO.name(), attractionAddDTO.city(), attractionAddDTO.price(),
                    attractionAddDTO.longitude(), attractionAddDTO.latitude(), attractionAddDTO.duration(), attractionAddDTO.recommendedAge());
            newAttraction.setCategory(categoryService.findByName(attractionAddDTO.category()));
            attractionService.save(newAttraction);
            return ResponseEntity.status(201).body(newAttraction);
        }
        return ResponseEntity.status(400).body("Incorrect provided data");
    }

    @PutMapping("/attractions/{id}")
    public ResponseEntity<?> updateAttraction(@PathVariable Long id, @RequestBody AttractionAddDTO attractionAddDTO) {

        Optional<Attraction> optionalAttraction = attractionService.findById(id);
        if (optionalAttraction.isPresent()) {
            if (attractionAddDTO.price() > 0 && attractionAddDTO.duration() > 0 && attractionAddDTO.recommendedAge() > 0
                    && attractionAddDTO.longitude() % 1 != 0 && attractionAddDTO.latitude() % 1 != 0
                    && categoryService.findByName(attractionAddDTO.category()) != null) {

                Attraction existingAttraction = optionalAttraction.get();
                existingAttraction.setName(attractionAddDTO.name());
                existingAttraction.setCity(attractionAddDTO.city());
                existingAttraction.setPrice(attractionAddDTO.price());
                existingAttraction.setLongitude(attractionAddDTO.longitude());
                existingAttraction.setLatitude(attractionAddDTO.latitude());
                existingAttraction.setDuration(attractionAddDTO.duration());
                existingAttraction.setRecommended_age(attractionAddDTO.recommendedAge());
                existingAttraction.setCategory(categoryService.findByName(attractionAddDTO.category()));
                attractionService.save(existingAttraction);
                return ResponseEntity.status(200).body(existingAttraction);
            }
        }
        return ResponseEntity.status(400).body("Incorrect provided data");

    }


    @GetMapping("/attractions")
    public ResponseEntity<?> searchByCategory(@RequestParam String category) {
        if (category.isEmpty()) {
            return ResponseEntity.ok().body(attractionService.findAll());
        }
        if (categoryService.findByName(category) == null) {
            return ResponseEntity.status(404).body("Category not found");
        }
        List<Attraction> attractionsByCategory = attractionService.findAttractionsByCategory(categoryService.findByName(category));
        return ResponseEntity.ok().body(attractionService.findCheapestAttraction(attractionsByCategory));
    }

}


