package com.example.reddit.service;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.model.Vote;
import com.example.reddit.repo.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    private VoteRepo voteRepo;

    public void upVote(Post post) {
        post.setScore(post.getScore() + 1);
    }

    public void downVote(Post post) {
        post.setScore(post.getScore() - 1);
    }
}
