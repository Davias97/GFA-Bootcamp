package com.example.federationweb.services;

import com.example.federationweb.models.Achievement;
import com.example.federationweb.models.Citizen;
import com.example.federationweb.repositories.AchievementRepository;
import com.example.federationweb.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementService {

    @Autowired
    private final AchievementRepository achievementRepository;

    @Autowired
    public AchievementService(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    public void saveAchievement(Achievement achievement) {
        achievementRepository.save(achievement);
    }
    public Optional<Achievement> findById(Long id) {
        return achievementRepository.findById(id);
    }

    public List<Achievement> listAchievements() {
        return achievementRepository.findAll();
    }


}
