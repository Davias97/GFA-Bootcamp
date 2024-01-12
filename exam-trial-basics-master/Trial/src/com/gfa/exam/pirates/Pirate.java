package com.gfa.exam.pirates;

public class Pirate {
    public String getName() {
        return name;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    protected String name;
    protected int goldAmount = 0;
    protected int healthPoints = 20;

    protected boolean hasWoodenLeg = false;


    public Pirate(String name) {
        this.name = name;
    }

    public boolean isPoor() {
        // return hasWoodenLeg && goldAmount < 15;
        if (hasWoodenLeg && goldAmount < 15) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String leg;
        if (hasWoodenLeg) {
            leg = ". I have a wooden leg";
        } else {
            leg = ". I still have my real legs";
        }


        return "Hello, I'm " + name + leg + " and" + goldAmount + " amount of gold.";
    }

    public void work() {
        goldAmount++;
        healthPoints--;
    }

    public void party() {
        healthPoints++;
    }
}
