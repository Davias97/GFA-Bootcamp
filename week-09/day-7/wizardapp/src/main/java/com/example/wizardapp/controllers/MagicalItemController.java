package com.example.wizardapp.controllers;

import com.example.wizardapp.DTOs.ErrorDTO;
import com.example.wizardapp.models.MagicalItem;
import com.example.wizardapp.models.Wizard;
import com.example.wizardapp.services.MagicalItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MagicalItemController {

    @Autowired
    MagicalItemService magicalItemService;


    public MagicalItemController(MagicalItemService magicalItemService) {
        this.magicalItemService = magicalItemService;
    }

    @GetMapping("/magicalitems")
    public ResponseEntity<?> listAllMagicalItems() {

        if (magicalItemService.listMagicalItems().isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Magical item list is empty"));
        } else
            return ResponseEntity.ok().body(magicalItemService.listMagicalItems());
    }

    @GetMapping("/magicalitems/{id}")
    public ResponseEntity<?> magicalItemDetail(@PathVariable Long id) {
        Optional<MagicalItem> optionalMagicalItem = magicalItemService.findById(id);

        if (optionalMagicalItem.isPresent()) {
            return ResponseEntity.ok(optionalMagicalItem.get());
        }
        return ResponseEntity.badRequest().body(new ErrorDTO("Magical item not found"));
    }

    @PutMapping("/magicalitems/{id}")
    public ResponseEntity<?> updateMagicalItem(@PathVariable Long id, @RequestBody MagicalItem updatedItem) {

        Optional<MagicalItem> optionalMagicalItem = magicalItemService.findById(id);

        if (optionalMagicalItem.isPresent()) {
            MagicalItem existingItem = optionalMagicalItem.get();
            existingItem.setName(updatedItem.getName());
            existingItem.setPowerLevel(updatedItem.getPowerLevel());
            magicalItemService.saveMagicalItem(existingItem);
            return ResponseEntity.ok(existingItem);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/magicalitems/{id}")
    public ResponseEntity<?> deleteMagicalItem(@PathVariable Long id) {

        Optional<MagicalItem> optionalMagicalItem = magicalItemService.findById(id);

        if (optionalMagicalItem.isPresent()) {
            magicalItemService.deleteMagicalItem(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/magicalitems/search")
    public ResponseEntity<?> searchMagicalItem(@RequestParam String name) {

        MagicalItem searchResult = magicalItemService.searchMagicalitemsByName(name);

        if (searchResult != null) {
            return ResponseEntity.ok(searchResult);
        }
        return ResponseEntity.notFound().build();
    }
}