package com.example.orientationexamretake.controllers;

import com.example.orientationexamretake.DTOs.AttractionAddDTO;
import com.example.orientationexamretake.models.Attraction;
import com.example.orientationexamretake.models.Category;
import com.example.orientationexamretake.services.AttractionService;
import com.example.orientationexamretake.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    AttractionService attractionService;
    CategoryService categoryService;

    public MainController(AttractionService attractionService, CategoryService categoryService) {
        this.attractionService = attractionService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String getHome(Model model) {

        model.addAttribute("attractionList", attractionService.findAll());
        model.addAttribute("categoryList", categoryService.categoryList());

        return "index";
    }

    @PostMapping("/add")
    public String postHome(AttractionAddDTO attractionAddDTO, Model model) {
        if (attractionAddDTO.price() > 0 && attractionAddDTO.duration() > 0 && attractionAddDTO.recommendedAge() > 0
                && attractionAddDTO.longitude() % 1 != 0 && attractionAddDTO.latitude() % 1 != 0
                && categoryService.findByName(attractionAddDTO.category()) != null) {
            Attraction newAttraction = new Attraction(attractionAddDTO.name(), attractionAddDTO.city(), attractionAddDTO.price()
                    , attractionAddDTO.longitude(), attractionAddDTO.latitude(), attractionAddDTO.duration(),
                    attractionAddDTO.recommendedAge(), categoryService.findByName(attractionAddDTO.category()));

            attractionService.save(newAttraction);

            return "redirect:/";
        }
        model.addAttribute("error", "Incorrect provided data!");
        return "index";
    }
}
