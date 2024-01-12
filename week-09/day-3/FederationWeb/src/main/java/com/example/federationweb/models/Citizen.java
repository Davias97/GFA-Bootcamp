package com.example.federationweb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Citizen {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int score;
    private String role;

    @OneToMany(mappedBy = "citizen")
    private List<Achievement> achievements;
    public Citizen(String name, int score, String role) {
        this.name = name;
        this.score = score;
        this.role = role;
    }

    public Citizen(String name) {
        this.name = name;
    }

    public Citizen() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }
}