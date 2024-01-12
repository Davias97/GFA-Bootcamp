package thegardenapplication;

import java.util.ArrayList;
import java.util.List;

public class Plant {
    protected String color;
    protected int amountOfWater = 0;
    protected double absorption;
    protected double minimumWater;

    public Plant(String color, double absorption, double minimumWater) {
        this.color = color;
        this.absorption = absorption;
        this.minimumWater = minimumWater;
    }

    public void getWater(int amount) {
        amountOfWater += amount * absorption;
    }

    public boolean needWater() {
        if (amountOfWater < minimumWater) {
            return true;
        } else {
            return false;
        }
    }

    public void needsWater() {
        if (needWater()) {
            System.out.println("The " + color + " " + this.getClass().getSimpleName() + " needs water.");
        } else {
            System.out.println("The " + color + " " + this.getClass().getSimpleName() + " doesn't need water.");
        }
    }
}
