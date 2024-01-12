package com.example.lotrapp;

import com.example.lotrapp.models.Character;
import com.example.lotrapp.models.Weapon;
import com.example.lotrapp.services.CharacterService;
import com.example.lotrapp.services.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Component
public class LotrappApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LotrappApplication.class, args);
    }

    @Autowired
    CharacterService characterService;
    @Autowired
    WeaponService weaponService;


    @Override
    public void run(String... args) throws Exception {
        List<Weapon> weapons = weaponService.listWeapons();

        if (weapons.size() == 0) {

            Character character1 = new Character("Sauron", "Maia");
            Character character2 = new Character("Galadriel", "Elf");

            characterService.saveCharacter(character1);
            characterService.saveCharacter(character2);

            Weapon weapon1 = new Weapon("Mace of Sauron", 999);
            Weapon weapon2 = new Weapon("Galadriel bitchslap", 999);

            weapon1.setCharacter(character1);
            weapon2.setCharacter(character2);

            weaponService.saveWeapon(weapon1);
            weaponService.saveWeapon(weapon2);
        }
    }
}
