package com.example.p2pchat;

import com.example.p2pchat.models.Client;
import com.example.p2pchat.models.Message;
import com.example.p2pchat.repositories.ClientRepository;
import com.example.p2pchat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class P2pChatApplication implements CommandLineRunner {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    MessageRepository messageRepository;

    public static void main(String[] args) {
        SpringApplication.run(P2pChatApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
