package com.example.url_aliaser.services;

import com.example.url_aliaser.models.Alias;
import com.example.url_aliaser.models.Link;
import com.example.url_aliaser.repositories.AliasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AliasService {

    AliasRepository aliasRepository;


    public AliasService(AliasRepository aliasRepository) {
        this.aliasRepository = aliasRepository;
    }

    public void save(Alias alias){
        aliasRepository.save(alias);
    }

    public Alias findByAlias(String alias){
        if (aliasRepository.findAliasByAlias(alias) != null){
            return aliasRepository.findAliasByAlias(alias);
        }
        return null;
    }

    public Alias findBySecretCode(String secretCode){
        if (aliasRepository.findAliasBySecretCode(secretCode) != null){
            return aliasRepository.findAliasBySecretCode(secretCode);
        }
        return null;
    }

    public void increment(Alias alias){
        alias.setHitCount(alias.getHitCount()+1);
        aliasRepository.save(alias);
    }

    public List<Alias> findAll() {
        return aliasRepository.findAll();
    }

    public Optional<Alias> findById(Long id) {
        return aliasRepository.findById(id);
    }

    public void deleteAlias(Long id) {
        aliasRepository.deleteById(id);
    }
}
