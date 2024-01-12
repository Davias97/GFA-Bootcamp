package com.example.federationweb.controllers;

import com.example.federationweb.models.Citizen;
import com.example.federationweb.repositories.CitizenRepository;
import com.example.federationweb.services.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/galactic_gov")
public class CitizenController {

    @Autowired
    CitizenRepository citizenRepository;
    @Autowired
    CitizenService citizenService;

    @GetMapping("/home")
    public String homePage() {

        return "home_page";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        Citizen citizen = new Citizen();
        model.addAttribute("citizen", citizen);
        return "register_page";
    }

    @PostMapping("/register")
    public String postRegisterPage(@ModelAttribute Citizen citizen) {

        citizenService.saveCitizen(citizen);
        return "redirect:/galactic_gov/entry_exam";
    }

    @GetMapping("/entry_exam")
    public String getExamPage() {

        return "entry_exam";
    }

    @PostMapping("/entry_exam")
    public String postExamPage(@RequestParam String q1, @RequestParam String q2, @RequestParam String q3) {
        Citizen citizen = citizenRepository.findCitizenById(1L);
        int score = 0;

        boolean isQ1Correct = "c".equals(q1);
        boolean isQ2Correct = "c".equals(q2);
        boolean isQ3Correct = "b".equals(q3);

        if (isQ1Correct) {
            score++;
        }
        if (isQ2Correct) {
            score++;
        }
        if (isQ3Correct) {
            score++;
        }

        citizen.setScore(score);
        citizenService.saveCitizen(citizen);

        if (score == 1) {
            citizenService.assignRole(citizen);
            return "redirect:/galactic_gov/enlistment_inf";
        } else if (score == 2) {
            citizenService.assignRole(citizen);
            return "redirect:/galactic_gov/enlistment_pilot";
        } else if (score == 3) {
            citizenService.assignRole(citizen);
            return "redirect:/galactic_gov/enlistment_psychic";
        }
        return "redirect:/galactic_gov/home";
    }

    @GetMapping("/enlistment_inf")
    public String getEnlistInf() {
        return "enlistment_inf";
    }
}

