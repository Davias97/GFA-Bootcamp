package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWebController {

    AtomicLong greetCount = new AtomicLong(0);
    String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
            "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
            "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
            "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

    @RequestMapping("/web/greeting")
    public String greetMethod(Model model) {

        model.addAttribute("name", "DABUNA");
        model.addAttribute("counter", greetCount.incrementAndGet());

        return "greeting";
    }

    @RequestMapping("/web/greetingAll")
    public String greetMethodAll(Model model,@RequestParam("fontSize") int size, @RequestParam("color") String color) {

        Random random = new Random();
        int index = random.nextInt(hellos.length);
        String randomHello = hellos[index];

        model.addAttribute("name", "DABUNA");
        model.addAttribute("hello", randomHello);
        model.addAttribute("size", size);
        model.addAttribute("color", color);

        return "greetingAll";
    }
}