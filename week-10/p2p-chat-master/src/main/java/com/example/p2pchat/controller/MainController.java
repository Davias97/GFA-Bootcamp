package com.example.p2pchat.controller;

import com.example.p2pchat.models.Client;
import com.example.p2pchat.models.Message;
import com.example.p2pchat.services.ClientService;
import com.example.p2pchat.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class MainController {

    private Client currentClient = null;
    ClientService clientService;
    MessageService messageService;

    public MainController(ClientService clientService, MessageService messageService) {
        this.clientService = clientService;
        this.messageService = messageService;
    }
    @PutMapping("/")
    public String sendMessage(String text){
        Message message = new Message(text);
        message.setClient(currentClient);
        message.setUsername(currentClient.getId());
        messageService.save(message);
        currentClient.addMessage(message);
        clientService.save(currentClient);
        return "redirect:/";

    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("client", currentClient);
        model.addAttribute("messages", messageService.findAll());
        return "index";
    }

    @PostMapping("/")
    public String logging(Model model, String username) {
       Client currentClient = clientService.findOne(username);
        if (currentClient == null) {
            model.addAttribute("error", "this user is not registered");
            return "index";
        }
        this.currentClient = currentClient;
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registrationOfNewClient(String username, Model model) {
        if (username == null || username.isBlank()) {
            model.addAttribute("error", "you have to enter your name");
            return "register";
        }
        currentClient = new Client(username);
        clientService.save(currentClient);
        return "redirect:/";
    }

}
