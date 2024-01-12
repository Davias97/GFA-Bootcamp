package com.example.url_aliaser.services;

import com.example.url_aliaser.models.Link;
import com.example.url_aliaser.repositories.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {

    LinkRepository linkRepository;


    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public void save(Link link){
        linkRepository.save(link);
    }

    public Link findByUrl(String url){
        if (linkRepository.findLinkByUrl(url) != null){
            return linkRepository.findLinkByUrl(url);
        }
        return null;
    }
    public List<Link> findAll() {
        return linkRepository.findAll();
    }

    public Optional<Link> findById(Long id) {
        return linkRepository.findById(id);
    }

    public void deleteLink(Long id) {
        linkRepository.deleteById(id);
    }
}


