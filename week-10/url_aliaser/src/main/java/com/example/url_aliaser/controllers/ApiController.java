package com.example.url_aliaser.controllers;

import com.example.url_aliaser.DTOs.AliasDTO;
import com.example.url_aliaser.DTOs.DeleteDTO;
import com.example.url_aliaser.models.Alias;
import com.example.url_aliaser.services.AliasService;
import com.example.url_aliaser.services.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiController {

    AliasService aliasService;
    LinkService linkService;


    public ApiController(AliasService aliasService, LinkService linkService) {
        this.aliasService = aliasService;
        this.linkService = linkService;
    }

    @GetMapping("/aliases")
    public ResponseEntity<?> getAliases() {

        List<Alias> aliasList = aliasService.findAll();
        return ResponseEntity.ok(aliasList.stream().map(AliasDTO::new).collect(Collectors.toList()));
    }

    @DeleteMapping("/aliases/{id}")
    public ResponseEntity<?> deleteAlias(@PathVariable Long id, @RequestBody DeleteDTO deleteDTO) {
        Optional<Alias> optionalAlias = aliasService.findById(id);

        if (optionalAlias.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (!optionalAlias.get().getSecretCode().equals(deleteDTO.secretCode())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        linkService.deleteLink(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
