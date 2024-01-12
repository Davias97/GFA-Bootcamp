package com.example.lotrapp.services;

import com.example.lotrapp.models.Character;
import com.example.lotrapp.models.Weapon;
import com.example.lotrapp.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character saveCharacter(Character character) {

        return characterRepository.save(character);
    }

    public Optional<Character> findById(Long id) {
        return characterRepository.findById(id);
    }

    public List<Character> listCharacters() {
        return characterRepository.findAll();
    }
}
