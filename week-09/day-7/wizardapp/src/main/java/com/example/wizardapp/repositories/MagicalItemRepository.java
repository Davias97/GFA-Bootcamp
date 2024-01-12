package com.example.wizardapp.repositories;

import com.example.wizardapp.models.MagicalItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagicalItemRepository extends JpaRepository<MagicalItem, Long> {
    List<MagicalItem> findAll();

    MagicalItem findMagicalItemByName(String name);
}
