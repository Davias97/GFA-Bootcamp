package com.example.databaseintegration.controller;

import com.example.databaseintegration.model.Assignee;
import com.example.databaseintegration.repository.AssigneeRepository;
import com.example.databaseintegration.service.AssigneeService;
import com.example.databaseintegration.service.TodoService;
import com.example.databaseintegration.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;
    private AssigneeService assigneeService;

    @Autowired
    public TodoController(TodoService todoService, AssigneeService assigneeService) {
        this.todoService = todoService;
        this.assigneeService = assigneeService;
    }

    @GetMapping(value = {"/list", "/"})
    public String list(Model m) {
        m.addAttribute("todos", todoService.listTodo());
        return "todolist";
    }

    @GetMapping("/add")
    public String showAddTodoForm(Model m) {
        m.addAttribute("todo", new Todo());
        return "addTodo";
    }

    @PostMapping("/add")
    public String addNewTodo(@ModelAttribute Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/todo/list";
    }

    @PostMapping("/{id}/delete")
    public String deleteTodo(@PathVariable long id) {
        todoService.deleteTodo(id);
        return "redirect:/todo/list";
    }

    @GetMapping(value = {"/list/{value}"})
    public String listValue(Model m, @PathVariable String value) {
        m.addAttribute("todos", todoService.listTodo());
        return "redirect:/todo/list";
    }

    @GetMapping("/listAssignees")
    public String listAssignees(Model m) {
        m.addAttribute("assignees", assigneeService.listAssignees());
        return "listAssignees";
    }

    @GetMapping("/search")
    public String search(String search,Boolean urgentSearch,Boolean doneSearch,Model model){
        model.addAttribute("todos", todoService.search(search,urgentSearch,doneSearch));

        return "todolist";
    }
}