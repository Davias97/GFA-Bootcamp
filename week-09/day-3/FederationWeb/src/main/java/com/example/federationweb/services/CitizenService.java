package com.example.federationweb.services;

import com.example.federationweb.models.Citizen;
import com.example.federationweb.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    @Autowired
    private final CitizenRepository citizenRepository;

    @Autowired
    public CitizenService(CitizenRepository citizenRepository) {

        this.citizenRepository = citizenRepository;

    }

    public void saveCitizen(Citizen citizen) {
        citizenRepository.save(citizen);
    }
    public Optional<Citizen> findById(Long id) {
        return citizenRepository.findById(id);
    }

    public List<Citizen> listPost() {
        return citizenRepository.findAll();
    }

    public void assignRole(Citizen citizen) {
        if (citizen.getScore() == 1) {
            citizen.setRole("Infantry");
        } else if (citizen.getScore() == 2) {
            citizen.setRole("Pilot");
        } else if (citizen.getScore() == 3) {
            citizen.setRole("Psychic");
        }
        saveCitizen(citizen);
    }
}