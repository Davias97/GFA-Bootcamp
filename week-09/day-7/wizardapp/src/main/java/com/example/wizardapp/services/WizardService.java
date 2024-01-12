package com.example.wizardapp.services;

import com.example.wizardapp.models.MagicalItem;
import com.example.wizardapp.models.Wizard;
import com.example.wizardapp.repositories.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WizardService {

    @Autowired
    WizardRepository wizardRepository;

    public WizardService(WizardRepository wizardRepository) {
        this.wizardRepository = wizardRepository;
    }

    public Wizard saveWizard(Wizard wizard) {

        return wizardRepository.save(wizard);
    }

    public Optional<Wizard> findById(Long id) {
        return wizardRepository.findById(id);
    }

    public List<Wizard> listWizards() {
        return wizardRepository.findAll();
    }

    public void deleteWizard(Long id) {
        wizardRepository.deleteById(id);
    }

    public List<Wizard> searchWizardsByName(String name) {
        return wizardRepository.findWizardByName(name);
    }
}

