package com.example.p2pchat.controllers;

import com.example.p2pchat.DTOs.ErrorDTO;
import com.example.p2pchat.models.Client;
import com.example.p2pchat.models.Message;
import com.example.p2pchat.services.ClientService;
import com.example.p2pchat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @Autowired
    ClientService clientService;
    @Autowired
    MessageService messageService;

    @GetMapping("/")
    public String getHome(Model model) {

        model.addAttribute("clients", clientService.listClients());

        return "home";
    }

    @PostMapping("/")
    public String postHome(Model model, @RequestParam String message) {
        Message newMessage = new Message(message);
        messageService.saveMessage(newMessage);
        clientService.findById(2L).getMessageList().add(newMessage);
        newMessage.setClient(clientService.findById(2L));
        clientService.save(clientService.findById(2L));
        model.addAttribute("message", newMessage);
        return "redirect:/";

    }

    @PutMapping("/")
    public String putHome(Model model, @RequestParam String name) {
        if (name.isEmpty()) {
            ErrorDTO errorDTO = new ErrorDTO("The username field is empty!");
            model.addAttribute("error", errorDTO);
            return "invalidinput";
        }
        Client optionalClient = clientService.findById(2L);

        if (optionalClient != null) {
            optionalClient.setUsername(name);
            clientService.save(optionalClient);
            model.addAttribute("client", optionalClient);
            return "home";
        }
        return "invalidinput";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute Client client, Model model) {

        if (client.getUsername().isEmpty()) {
            ErrorDTO errorDTO = new ErrorDTO("The username field is empty!");
            model.addAttribute("error", errorDTO);
            return "invalidinput";
        }
        clientService.save(client);
        return "redirect:/";
    }
}
