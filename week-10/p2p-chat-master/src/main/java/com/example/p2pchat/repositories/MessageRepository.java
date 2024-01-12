package com.example.p2pchat.repositories;

import com.example.p2pchat.models.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Long> {
    List<Message> findAll();
}
