package com.example.foxproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private FoxService foxService;

    @GetMapping("/")
    public String index(@RequestParam(required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            Fox fox = foxService.getFox(name);
            model.addAttribute("fox", fox);
            return "information";
        } else {
            return "index";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String name, RedirectAttributes attributes) {
        // Logic to handle the name parameter
        // Redirect to the main page with the name parameter
        return "redirect:/?name=" + name;
    }

    @GetMapping("/nutritionStore")
    public String nutritionStore(@RequestParam String name, Model model) {
        Fox fox = foxService.getFox(name);
        model.addAttribute("fox", fox);

        // Assuming you have a list of predefined food and drink options
        List<String> foodOptions = Arrays.asList("Food1", "Food2", "Food3"); // Add your specific food items
        List<String> drinkOptions = Arrays.asList("Drink1", "Drink2", "Drink3"); // Add your specific drink items
        model.addAttribute("foodOptions", foodOptions);
        model.addAttribute("drinkOptions", drinkOptions);

        return "nutritionStore";
    }

    @PostMapping("/updateNutrition")
    public String updateNutrition(@RequestParam String name, @RequestParam String food, @RequestParam String drink) {
        foxService.updateNutrition(name, food, drink);
        return "redirect:/?name=" + name;
    }

    @GetMapping("/trickCenter")
    public String trickCenter(@RequestParam String name, Model model) {
        Fox fox = foxService.getFox(name);
        List<String> availableTricks = Arrays.asList("Trick1", "Trick2", "Trick3"); // Add your specific tricks
        model.addAttribute("fox", fox);
        model.addAttribute("availableTricks", availableTricks);
        return "trickCenter";
    }

    @PostMapping("/learnTrick")
    public String learnTrick(@RequestParam String name, @RequestParam String trick) {
        foxService.learnTrick(name, trick);
        return "redirect:/trickCenter?name=" + name;
    }

    @GetMapping("/actionHistory")
    public String actionHistory(Model model) {
        // Get the action history from the service
        List<String> actionHistory = foxService.getActionHistory();

        model.addAttribute("actionHistory", actionHistory);
        return "actionHistory";
    }
}