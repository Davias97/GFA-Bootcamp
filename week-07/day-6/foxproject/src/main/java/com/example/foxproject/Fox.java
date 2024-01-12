package com.example.foxproject;

import java.util.ArrayList;
import java.util.List;

public class Fox {
    private String name;
    private List<String> tricks;
    private String food;
    private String drink;

    // Constructors, Getters, Setters (Lombok can be used for convenience)

    public Fox(String name) {
        this.name = name;
        this.tricks = new ArrayList<>();
        // Set default food and drink
        this.food = "default food";
        this.drink = "default drink";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public void setTricks(List<String> tricks) {
        this.tricks = tricks;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
    // Other methods to manage tricks, food, and drink
}