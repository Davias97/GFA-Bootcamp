package com.example.p2pchat.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class Message {

    @Id
    private Long id = (new Random().nextLong(1_000_000, 10_000_000));
    private String username;
    private String text;
    private Long timestamp = System.currentTimeMillis();
    @ManyToOne
    private Client client;

    public Message(String text) {
        this.text = text;
    }
}
