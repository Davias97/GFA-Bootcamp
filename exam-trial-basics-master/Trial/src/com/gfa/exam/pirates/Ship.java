package com.gfa.exam.pirates;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    List<Pirate> crew = new ArrayList<>();
    boolean hasCaptain = false;

    public boolean addPirate(Pirate pirate) {
        //crew.contains(Captain.class); nebude fungovat
        if (pirate instanceof Captain && hasCaptain) {
            // this would be a second captain
            return false;
        }
        if (pirate instanceof Captain) {
            hasCaptain = true;

        }
        crew.add(pirate);
        return true;
    }

    public int getCrewSize() {
        return crew.size();
    }

    public List<String> getPoorPirates() {
        List<String> names = new ArrayList<>();
        for (Pirate pirate : crew) {
            if (pirate.isPoor()){
                names.add(pirate.getName());
            }
        }
        return names;
    }

    public int getTotalGold() {
        int sum = 0;
        for (Pirate pirate : crew) {
            if (pirate.isPoor()){
                sum += pirate.getGoldAmount();
            }
        }
        return sum;
    }

    public void lastDayOnTheShip() {
        for (Pirate pirate : crew) {
            pirate.party();
        }
    }

    public void prepareForBattle() {
        for (Pirate pirate : crew) {
            for (int i = 0; i < 5; i++) {
                pirate.work();
            }

        }
        lastDayOnTheShip();
    }


}
