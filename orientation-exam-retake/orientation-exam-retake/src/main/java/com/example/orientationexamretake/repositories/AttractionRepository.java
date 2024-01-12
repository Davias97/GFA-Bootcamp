package com.example.orientationexamretake.repositories;

import com.example.orientationexamretake.models.Attraction;
import com.example.orientationexamretake.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    List<Attraction> findAll();

    List<Attraction> findAttractionByCategory(Category category);
}
