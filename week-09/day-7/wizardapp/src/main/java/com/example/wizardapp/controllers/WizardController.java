package com.example.wizardapp.controllers;

import com.example.wizardapp.DTOs.ErrorDTO;
import com.example.wizardapp.DTOs.WizardDTO;
import com.example.wizardapp.models.Wizard;
import com.example.wizardapp.services.MagicalItemService;
import com.example.wizardapp.services.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WizardController {

    @Autowired
    private WizardService wizardService;


    public WizardController(WizardService wizardService) {
        this.wizardService = wizardService;
    }

    @GetMapping("/wizards")
    public ResponseEntity<?> listAllWizards() {

        if (wizardService.listWizards().isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Wizard list is empty"));
        } else
            return ResponseEntity.ok().body(wizardService.listWizards());
    }

    @GetMapping("/wizards/{id}")
    public ResponseEntity<?> wizardDetail(@PathVariable Long id) {

        Optional<Wizard> optionalWizard = wizardService.findById(id);

        if (optionalWizard.isPresent()) {
            return ResponseEntity.ok(optionalWizard.get());
        }
        return ResponseEntity.badRequest().body(new ErrorDTO("Wizard not found"));
    }

    @PutMapping("/wizards/{id}")
    public ResponseEntity<?> updateWizard(@PathVariable Long id, @RequestBody Wizard updatedWizard) {

        Optional<Wizard> optionalWizard = wizardService.findById(id);

        if (optionalWizard.isPresent()) {
            Wizard existingWizard = optionalWizard.get();
            existingWizard.setName(updatedWizard.getName());
            existingWizard.setAge(updatedWizard.getAge());
            wizardService.saveWizard(existingWizard);
            return ResponseEntity.ok(existingWizard);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/wizards/{id}")
    public ResponseEntity<?> deleteWizard(@PathVariable Long id) {

        Optional<Wizard> optionalWizard = wizardService.findById(id);

        if (optionalWizard.isPresent()) {
            wizardService.deleteWizard(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/wizards/search")
    public ResponseEntity<?> searchWizards(@RequestParam String name) {

        List<Wizard> searchResults = wizardService.searchWizardsByName(name);

        if (!searchResults.isEmpty()) {
            return ResponseEntity.ok(searchResults);
        }
        return ResponseEntity.notFound().build();
    }
}