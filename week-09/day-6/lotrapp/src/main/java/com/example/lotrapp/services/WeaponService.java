package com.example.lotrapp.services;

import com.example.lotrapp.models.Character;
import com.example.lotrapp.models.Weapon;
import com.example.lotrapp.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeaponService {

    @Autowired
    WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public Weapon saveWeapon(Weapon weapon) {

        return weaponRepository.save(weapon);
    }

    public Optional<Weapon> findById(Long id) {
        return weaponRepository.findById(id);
    }

    public List<Weapon> listWeapons() {
        return weaponRepository.findAll();
    }

}
