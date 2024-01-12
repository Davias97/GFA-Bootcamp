package com.example.wizardapp.services;

import com.example.wizardapp.models.MagicalItem;
import com.example.wizardapp.models.Wizard;
import com.example.wizardapp.repositories.MagicalItemRepository;
import com.example.wizardapp.repositories.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MagicalItemService {

    @Autowired
    MagicalItemRepository magicalItemRepository;

    public MagicalItemService(MagicalItemRepository magicalItemRepository) {
        this.magicalItemRepository = magicalItemRepository;
    }

    public MagicalItem saveMagicalItem(MagicalItem magicalItem) {

        return magicalItemRepository.save(magicalItem);
    }

    public Optional<MagicalItem> findById(Long id) {
        return magicalItemRepository.findById(id);
    }

    public List<MagicalItem> listMagicalItems() {
        return magicalItemRepository.findAll();
    }

    public void deleteMagicalItem(Long id) {
        magicalItemRepository.deleteById(id);
    }

    public MagicalItem searchMagicalitemsByName(String name) {
        return magicalItemRepository.findMagicalItemByName(name);
    }
}
