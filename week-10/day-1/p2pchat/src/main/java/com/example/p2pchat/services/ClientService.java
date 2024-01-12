package com.example.p2pchat.services;

import com.example.p2pchat.models.Client;
import com.example.p2pchat.models.Message;
import com.example.p2pchat.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }
    public Client searchClient(String name) {
       return clientRepository.findClientByUsername(name);
    }
    public List<Client> listClients() {
        return clientRepository.findAll();
    }
    public Client findById(Long id) {
        return clientRepository.findClientById(id);
    }
}
