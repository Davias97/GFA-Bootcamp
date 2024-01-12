package com.example.p2pchat.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {


    @Id
    private String id;


    @OneToMany(mappedBy = "client")
    List<Message> messageList = new ArrayList<>();

    public Client(String username) {
        this.id = username;
    }

    public void addMessage(Message message){
        messageList.add(message);
    }

}
