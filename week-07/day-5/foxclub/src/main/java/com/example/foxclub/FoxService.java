package com.example.foxclub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoxService {

    @Autowired
    private FoxRepository foxrepo;

    public void foxCheck(String name) {
        if (!foxrepo.foxCheck(name)) {
            foxrepo.addFox(new Fox(name));
        }
    }

    public int numberOfTricks(String name) {

        return foxrepo.getFox(name).getTricks().size();
    }

    public void addFoodDrink(String name, String food, String drink) {
        foxrepo.getFox(name).setFood(food);
        foxrepo.getFox(name).setDrink(drink);
    }

    public String getFood(String name) {
        return foxrepo.getFox(name).getFood();
    }

    public String getDrink(String name) {
        return foxrepo.getFox(name).getDrink();
    }

    public void setTrick(String name, String trick) {
        if (!checkTricks(name, trick)) {
            foxrepo.getFox(name).getTricks().add(trick);
        }
    }

    public List<String> getTricks(String name) {
        return foxrepo.getFox(name).getTricks();
    }

    public boolean checkTricks(String name, String word) {
        return foxrepo.getFox(name).getTricks().stream().anyMatch(str -> str.contains(word));
    }
}
