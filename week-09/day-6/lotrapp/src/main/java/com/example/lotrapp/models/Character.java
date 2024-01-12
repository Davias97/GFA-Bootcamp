package com.example.lotrapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Character {


    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String race;

    public Character() {}

    public Character(String name, String race){
        this.name = name;
        this.race = race;
    }

    @OneToMany(mappedBy = "character")
    private List<Weapon> weaponArsenal = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public List<Weapon> getWeaponArsenal() {
        return weaponArsenal;
    }

    public void setWeaponArsenal(List<Weapon> weaponArsenal) {
        this.weaponArsenal = weaponArsenal;
    }
}
