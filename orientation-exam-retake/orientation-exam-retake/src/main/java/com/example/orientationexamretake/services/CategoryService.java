package com.example.orientationexamretake.services;

import com.example.orientationexamretake.models.Attraction;
import com.example.orientationexamretake.models.Category;
import com.example.orientationexamretake.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public List<String> categoryList() {
        List<String> categories = new ArrayList<>();
        categories.add("restaurant");
        categories.add("aquapark");
        categories.add("park");
        categories.add("museum");
        categories.add("shopping mall");

        return categories;
    }

    public Category findByName(String name) {
        if (categoryRepository.findByName(name) != null) {
            return categoryRepository.findByName(name);
        }
        return null;
    }

    public void addToAttractionList(Attraction attraction) {
    }
}
