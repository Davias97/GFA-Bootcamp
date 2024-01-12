package thegardenapplication;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    private List<Plant> garden = new ArrayList<>();

    public void addPlant(Plant plant) {
        garden.add(plant);
    }

    public void info() {
        for (Plant plant : garden) {
            plant.needsWater();
        }
        System.out.println();
    }

    public void water(int waterAmount) {
        System.out.println("Watering with " + waterAmount + ":");

        int needsWater = 0;

        for (Plant plant : garden) {
            if (plant.needWater())
                needsWater += 1;
        }

        waterAmount /= needsWater;

        for (Plant plant : garden) {
            if (plant.needWater())
                plant.getWater(waterAmount);
        }
        this.info();
    }
}