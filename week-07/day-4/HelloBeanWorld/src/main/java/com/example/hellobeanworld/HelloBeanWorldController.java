package com.example.hellobeanworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloBeanWorldController {

   UtilityService utilService = new UtilityService();

    public HelloBeanWorldController() {

    }

    @GetMapping("/useful")
    public String showLinks() {


        return "dabu";
    }

    @GetMapping("/useful/colored")
    public String showColored(Model model) {

        String randomColor = utilService.generateRandomColor();
        model.addAttribute("randomColor", randomColor);

        return "dabu";
    }
}
