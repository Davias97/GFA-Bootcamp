package com.example.p2pchat.services;


import com.example.p2pchat.models.Message;
import com.example.p2pchat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService{

    @Autowired
    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMessage(Message message) {

        return messageRepository.save(message);
    }
    public List<Message> listMessages() {
        return messageRepository.findAll();
    }
}
