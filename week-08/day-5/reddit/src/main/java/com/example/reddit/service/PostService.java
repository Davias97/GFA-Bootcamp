package com.example.reddit.service;

import com.example.reddit.model.Post;
import com.example.reddit.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public Post savePost(Post p) {
        if (p.getId() == null) {
            p.setCreatedAt(LocalDateTime.now());
        }
        return postRepo.save(p);
    }

    public Optional<Post> findById(Long id) {
        return postRepo.findById(id);
    }

    public List<Post> listPost() {
        return postRepo.findAll();
    }
}
