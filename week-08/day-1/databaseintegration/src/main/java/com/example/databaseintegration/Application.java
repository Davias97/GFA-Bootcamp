package com.example.databaseintegration;

import com.example.databaseintegration.model.Assignee;
import com.example.databaseintegration.model.Todo;
import com.example.databaseintegration.repository.AssigneeRepository;
import com.example.databaseintegration.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Application implements CommandLineRunner {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    AssigneeRepository assigneeRepository;

    @Override
    public void run(String... args) {
        todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
        todoRepository.save(new Todo("Tvoje máma"));
        todoRepository.save(new Todo("Se nevejde"));
        todoRepository.save(new Todo("Do intu"));
        todoRepository.save(new Todo("Kundo"));
        assigneeRepository.save(new Assignee("Dabuna", "loktar@tromka.com"));
        assigneeRepository.save(new Assignee("Thrall", "orgrimmar@durotar.com"));
    }
}
