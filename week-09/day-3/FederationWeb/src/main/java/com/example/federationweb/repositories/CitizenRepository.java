package com.example.federationweb.repositories;

import com.example.federationweb.models.Citizen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends CrudRepository<Citizen, Long> {
    List<Citizen> findAll();
    Citizen findCitizenByName(String name);
    Citizen findCitizenById(long id);
}
