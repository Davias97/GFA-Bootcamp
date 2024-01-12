package com.example.orientationexamretake.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Attraction {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String city;
    private int price;
    private double longitude;
    private double latitude;
    private int duration;
    private int recommended_age;
    @ManyToOne
    private Category category;


    public Attraction(String name, String city, int price, double longitude, double latitude, int duration, int recommended_age) {
        this.name = name;
        this.city = city;
        this.price = price;
        this.longitude = longitude;
        this.latitude = latitude;
        this.duration = duration;
        this.recommended_age = recommended_age;
    }
    public Attraction(String name, String city, int price, double longitude, double latitude, int duration, int recommended_age, Category category) {
        this.name = name;
        this.city = city;
        this.price = price;
        this.longitude = longitude;
        this.latitude = latitude;
        this.duration = duration;
        this.recommended_age = recommended_age;
        this.category = category;
    }
}
