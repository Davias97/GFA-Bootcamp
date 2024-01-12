package com.example.orientationexamretake;

import com.example.orientationexamretake.models.Attraction;
import com.example.orientationexamretake.models.Category;
import com.example.orientationexamretake.services.AttractionService;
import com.example.orientationexamretake.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class OrientationExamRetakeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OrientationExamRetakeApplication.class, args);
    }

    @Autowired
    AttractionService attractionService;
    @Autowired
    CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {
        Attraction attraction1 = new Attraction("House of Horror","Prague", 200, 32.1245, 45.21234,50,18);
        Attraction attraction2 = new Attraction("Ghetto Drive By","Teplice", 100, 38.17895, 52.21234,90,10);
        Attraction attraction3 = new Attraction("Brewery visit","Pilsen", 420, 31.1287535, 63.21234,45,25);
        Category category1 = new Category("museum");
        Category category2 = new Category("car ride");
        Category category3 = new Category("brewery");
        Category category4 = new Category("restaurant");
        categoryService.save(category1);
        categoryService.save(category2);
        categoryService.save(category3);
        categoryService.save(category4);
        attraction1.setCategory(category1);
        attraction2.setCategory(category2);
        attraction3.setCategory(category3);

        attractionService.save(attraction1);
        attractionService.save(attraction2);
        attractionService.save(attraction3);
    }
}
