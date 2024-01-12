package com.example.databaseintegration.service;

import com.example.databaseintegration.model.Assignee;
import com.example.databaseintegration.model.Todo;
import com.example.databaseintegration.repository.AssigneeRepository;
import com.example.databaseintegration.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    private AssigneeRepository assigneeRepository;

    public TodoService(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
        this.todoRepository = todoRepository;
        this.assigneeRepository = assigneeRepository;
    }



    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public List<Todo> listTodo() {
        return todoRepository.findAll();
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> search(String title, Boolean urgent, Boolean done){
        return todoRepository.findTodosByTitleContainsIgnoreCaseAndUrgentAndDone(title,urgent,done);
    }

}
