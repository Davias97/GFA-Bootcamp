package com.example.reddit.repo;

import com.example.reddit.model.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepo extends CrudRepository<Vote, Long> {
    List<Vote> findAll();
}
