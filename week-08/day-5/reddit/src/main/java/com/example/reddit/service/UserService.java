package com.example.reddit.service;

import com.example.reddit.model.User;
import com.example.reddit.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    private User loggedUser = null;

    public User save(User user) {
        return userRepo.save(user);
    }
    public User findByName(String name) {
        return userRepo.findUserByName(name);
    }

    public boolean login(String name, String password) {
        User optionaluser = findByName(name);
        if (optionaluser != null && optionaluser.getPassword().equals(password)) {
            loggedUser = optionaluser;
            return true;
        } return false;
    }
}
