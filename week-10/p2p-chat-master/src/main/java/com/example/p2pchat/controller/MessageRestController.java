package com.example.p2pchat.controller;

import com.example.p2pchat.DTOs.ClientDTO;
import com.example.p2pchat.DTOs.MessageDTO;
import com.example.p2pchat.DTOs.MessageProtocolDTO;
import com.example.p2pchat.models.Client;
import com.example.p2pchat.models.Message;
import com.example.p2pchat.DTOs.ErrorDTO;
import com.example.p2pchat.services.ClientService;
import com.example.p2pchat.services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MessageRestController {

    MessageService messageService;
    ClientService clientService;

    public MessageRestController(MessageService messageService, ClientService clientService) {
        this.messageService = messageService;
        this.clientService = clientService;
    }


    @PostMapping("/api/message/receive")
    public ResponseEntity<?> sendMessage(@RequestBody Optional<MessageProtocolDTO> messageProtocol) {
        Message message1 = new Message(messageProtocol.get().message().text());
        Client client1 =  new Client(messageProtocol.get().client().id());
        message1.setClient(client1);
        message1.setUsername(messageProtocol.get().client().id());
        clientService.save(client1);
        messageService.save(message1);
        return ResponseEntity.ok().body(new MessageProtocolDTO(messageProtocol.get().message(), messageProtocol.get().client()));
    }

    @GetMapping("/api/message/receive")
    public ResponseEntity<?> receivedMessage() {
        return ResponseEntity.ok().body(messageService.findAll());
    }

}

