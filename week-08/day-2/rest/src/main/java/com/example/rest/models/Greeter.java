package com.example.rest.models;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class Greeter {

    public String getWelcome_message() {
        return welcome_message;
    }

    private String welcome_message;

    public Greeter(String name, String title) {
        welcome_message = "Oh, hi there " + name + "," + " my dear " + title + "!";
    }
}
