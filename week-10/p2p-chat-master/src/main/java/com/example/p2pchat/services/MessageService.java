package com.example.p2pchat.services;

import com.example.p2pchat.models.Message;
import com.example.p2pchat.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }
    public void save(Message message){
        messageRepository.save(message);
    }
}
