package com.example.wizardapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class MagicalItem {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int powerLevel;

    @ManyToOne
    @JsonIgnore
    private Wizard wizard;

    public MagicalItem() {}

    public MagicalItem(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
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

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }
}
