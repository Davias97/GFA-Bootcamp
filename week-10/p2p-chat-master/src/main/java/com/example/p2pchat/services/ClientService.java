package com.example.p2pchat.services;

import com.example.p2pchat.models.Client;
import com.example.p2pchat.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void save(Client client){
        clientRepository.save(client);
    }

    public Client findOne(String id){
      if (clientRepository.findById(id).isPresent()){
          return clientRepository.findById(id).get();
      }
      return null;
    }
}
