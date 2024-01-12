package com.example.p2pchat.repositories;

import com.example.p2pchat.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,String> {
}
