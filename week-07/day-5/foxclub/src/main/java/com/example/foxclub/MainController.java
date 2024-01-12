package com.example.foxclub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    FoxService foxService;

    @GetMapping( "/login")
    public String getLogin() {

        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String name) {
        foxService.foxCheck(name);
        return "redirect:/index?name=" + name;
    }

    @GetMapping("/index")
    public String getInfo(Model model, @RequestParam String name) {

        model.addAttribute("name", name);
        model.addAttribute("numberOfTricks", foxService.numberOfTricks(name));
        model.addAttribute("food", foxService.getFood(name));
        model.addAttribute("drink", foxService.getDrink(name));
        model.addAttribute("trickList", foxService.getTricks(name));

        return "index";
    }

    @PostMapping("/index")
    public String postInfo() {

        return "index";
    }

    @GetMapping("/nutritionstore")
    public String getNutrition(@RequestParam String name, Model model) {
        model.addAttribute("name", name);

        return "nutritionstore";
    }

    @PostMapping("/nutritionstore")
    public String postNutrition(@RequestParam String name, @RequestParam String food, @RequestParam String drink, Model model) {
        model.addAttribute("name", name);
        foxService.addFoodDrink(name, food, drink);

        return "nutritionstore";
    }

    @GetMapping("/trickcenter")
    public String getTrickPage(@RequestParam String name, Model model) {
        model.addAttribute("name", name);

        return "trickcenter";
    }

    @PostMapping("/trickcenter")
    public String postTrickPage(@RequestParam String name,@RequestParam String trick, Model model) {
        model.addAttribute("name", name);
        foxService.setTrick(name,trick);

        return "trickcenter";
    }
}