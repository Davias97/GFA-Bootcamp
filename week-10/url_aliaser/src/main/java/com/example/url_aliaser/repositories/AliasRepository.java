package com.example.url_aliaser.repositories;

import com.example.url_aliaser.models.Alias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AliasRepository extends JpaRepository<Alias, Long> {
    List<Alias> findAll();

    Alias findAliasByAlias(String alias);
    Alias findAliasBySecretCode(String secretCode);
}
