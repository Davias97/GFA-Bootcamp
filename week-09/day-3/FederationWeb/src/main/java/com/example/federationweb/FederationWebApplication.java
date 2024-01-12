package com.example.federationweb;

import com.example.federationweb.models.Achievement;
import com.example.federationweb.models.Citizen;
import com.example.federationweb.services.AchievementService;
import com.example.federationweb.services.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class FederationWebApplication implements CommandLineRunner {
    @Autowired
    private CitizenService citizenService;

    @Autowired
    private AchievementService achievementService;

    public static void main(String[] args) {
        SpringApplication.run(FederationWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Citizen citizen1 = new Citizen("Dabunator", 2, "Pilot");
        Citizen citizen2 = new Citizen("GalacticZugZug", 3, "Psychic");
        Citizen citizen3 = new Citizen("Tromka", 1, "Psychic");

        citizenService.saveCitizen(citizen1);
        citizenService.saveCitizen(citizen2);
        citizenService.saveCitizen(citizen3);

        Achievement achievement1 = new Achievement("Destroyer of Butts");
        Achievement achievement2 = new Achievement("Galactic Giga Chad");
        Achievement achievement3 = new Achievement("Cheek slayer");

        achievement1.setCitizen(citizen1);
        achievement2.setCitizen(citizen2);
        achievement3.setCitizen(citizen3);

        achievementService.saveAchievement(achievement1);
        achievementService.saveAchievement(achievement2);
        achievementService.saveAchievement(achievement3);


    }


}
