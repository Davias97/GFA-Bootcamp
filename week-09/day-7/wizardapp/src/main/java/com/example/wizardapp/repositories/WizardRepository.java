package com.example.wizardapp.repositories;

import com.example.wizardapp.models.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Long> {
    List<Wizard> findAll();
    List<Wizard> findWizardByName(String name);
}
