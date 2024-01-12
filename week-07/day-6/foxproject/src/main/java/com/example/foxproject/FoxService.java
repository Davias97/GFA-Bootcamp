package com.example.foxproject;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoxService {
    private Map<String, Fox> foxes = new HashMap<>();
    private List<String> actionHistory = new ArrayList<>();

    public Fox getFox(String name) {
        return foxes.computeIfAbsent(name, Fox::new);
    }

    public void updateNutrition(String name, String food, String drink) {
        Fox fox = foxes.get(name);
        if (fox != null) {
            fox.setFood(food);
            fox.setDrink(drink);
            actionHistory.add("Updated nutrition for " + name + " - Food: " + food + ", Drink: " + drink);
        }
    }

    public void learnTrick(String name, String trick) {
        Fox fox = foxes.get(name);
        if (fox != null) {
            if (!fox.getTricks().contains(trick)) {
                fox.getTricks().add(trick);
                actionHistory.add(name + " learned a new trick: " + trick);
            }
        }
    }

    public List<String> getActionHistory() {
        // You can implement logic to retrieve a limited history (e.g., last five actions)
        return actionHistory;
    }
}