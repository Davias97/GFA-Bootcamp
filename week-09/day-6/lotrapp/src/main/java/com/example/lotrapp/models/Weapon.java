package com.example.lotrapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Weapon {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int damage;
    @ManyToOne
    @JsonIgnore
    private Character character;

    public Weapon() {
    }

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
