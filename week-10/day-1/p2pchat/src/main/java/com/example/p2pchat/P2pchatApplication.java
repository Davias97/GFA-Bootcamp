package com.example.p2pchat;

import com.example.p2pchat.models.Client;
import com.example.p2pchat.models.Message;
import com.example.p2pchat.services.ClientService;
import com.example.p2pchat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class P2pchatApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(P2pchatApplication.class, args);
    }

    @Autowired
    MessageService messageService;
    @Autowired
    ClientService clientService;

    @Override
    public void run(String... args) throws Exception {
        Client  defaultClient = new Client("App");
        clientService.save(defaultClient);
        Message defaultMessage = new Message("Hi there! Submit your message using the send button!");
        defaultMessage.setClient(defaultClient);
        messageService.saveMessage(defaultMessage);
    }
}
