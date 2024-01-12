package com.example.p2pchat.repositories;

import com.example.p2pchat.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAll();
    Client findClientByUsername(String name);

    Client findClientById(Long id);
}
