package com.example.lotrapp.controllers;

import com.example.lotrapp.models.Character;
import com.example.lotrapp.repositories.CharacterRepository;
import com.example.lotrapp.repositories.WeaponRepository;
import com.example.lotrapp.services.CharacterService;
import com.example.lotrapp.services.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    WeaponRepository weaponRepository;
    @Autowired
    CharacterService characterService;
    @Autowired
    WeaponService weaponService;

    @GetMapping("/characters")
    public String listAllCharacters(Model model) {

        model.addAttribute("characters", characterService.listCharacters());

        return "characters";
    }

    @GetMapping("/characters/{id}")
    public String characterDetail(Model model, @PathVariable Long id) {
        Optional<Character> optionalCharacter = characterService.findById(id);

        if (optionalCharacter.isPresent()) {
            Character character = optionalCharacter.get();
            model.addAttribute("character", character);
            return "characterdetail";
        }
        return "404";
    }

    @GetMapping("/addCharacter")
    public String getAddCharacter(Model model) {

        Character newCharacter = new Character();
        model.addAttribute("character", newCharacter);

        return "addcharacter";
    }

    @PostMapping("/addCharacter")
    public String postAddCharacter(@ModelAttribute Character character) {

        characterService.saveCharacter(character);

        return "redirect:/characters";
    }
}
