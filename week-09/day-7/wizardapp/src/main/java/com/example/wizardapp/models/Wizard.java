package com.example.wizardapp.models;

import com.example.wizardapp.services.WizardService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Wizard {


    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "wizard", cascade = CascadeType.REMOVE)
    private List<MagicalItem> magicalItemList = new ArrayList<>();

    public Wizard() {}

    public Wizard(String name, int age) {
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<MagicalItem> getMagicalItemList() {
        return magicalItemList;
    }

    public void setMagicalItemList(List<MagicalItem> magicalItemList) {
        this.magicalItemList = magicalItemList;
    }
}
