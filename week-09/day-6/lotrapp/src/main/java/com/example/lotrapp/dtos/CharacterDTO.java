package com.example.lotrapp.dtos;

import com.example.lotrapp.models.Weapon;

public record CharacterDTO(String name, String race, Long id, Weapon weapon) {
}
