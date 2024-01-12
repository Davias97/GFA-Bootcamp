package com.example.rocketship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RocketController {

    @GetMapping("/")
    public String mainPage() {
        return "mainpage";
    }

}
