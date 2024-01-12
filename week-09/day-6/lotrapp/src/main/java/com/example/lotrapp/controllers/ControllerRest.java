package com.example.lotrapp.controllers;

import com.example.lotrapp.dtos.ErrorDTO;
import com.example.lotrapp.models.Character;
import com.example.lotrapp.services.CharacterService;
import com.example.lotrapp.services.WeaponService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ControllerRest {
    private CharacterService characterService;
    private WeaponService weaponService;

    public ControllerRest(CharacterService characterService, WeaponService weaponService) {
        this.characterService = characterService;
        this.weaponService = weaponService;
    }

//    @GetMapping("/characters")
//    public ResponseEntity<?> listAllCharacters(Optional<Character> character) {
//
//        if (characterService.listCharacters().isEmpty()) {
//            return ResponseEntity.badRequest().body(new ErrorDTO("Character list is empty"));
//        } else
//            return ResponseEntity.ok().body(characterService.listCharacters());
//    }
//
//    @GetMapping("/characters/{id}")
//    public ResponseEntity<?> characterDetail(@PathVariable Long id) {
//        Optional<Character> optionalCharacter = characterService.findById(id);
//
//        if (optionalCharacter.isPresent()) {
//            return ResponseEntity.ok(optionalCharacter.get());
//        }
//        return ResponseEntity.badRequest().body(new ErrorDTO("Character list is empty"));
//    }
}
