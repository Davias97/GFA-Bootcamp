package com.example.url_aliaser.repositories;

import com.example.url_aliaser.models.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    List<Link> findAll();
    Link findLinkByUrl(String url);
}
