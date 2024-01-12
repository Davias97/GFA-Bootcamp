package com.example.url_aliaser.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Alias {

    @Id
    @GeneratedValue
    private Long id;
    private String alias;
    private int hitCount;
    private String secretCode = generateSecretCode();

    @ManyToOne
    private Link link;


    public Alias(String alias) {
        this.alias = alias;
    }

    public String generateSecretCode() {

        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(1000,9999);

        return String.valueOf(randomNumber);
    }
}
