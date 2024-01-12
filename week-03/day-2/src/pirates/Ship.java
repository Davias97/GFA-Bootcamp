package pirates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {

    private List<Pirate> crew;
    private Pirate captain;
    private boolean isAlive;


    public void ship() {
        this.crew = new ArrayList<>();
        this.captain = null;
    }

    public void fillShip() {
        this.captain = new Pirate();
        captain.pirate();
        Random random = new Random();
        int shipCrewSize = random.nextInt(114);
        for (int i = 0; i < shipCrewSize; i++) {
            crew.add(new Pirate());
        }
    }

    public void getShipInfo() {
        System.out.println("Captain drank " + captain.howManyShots() + " shots of rum and is " + captain.isPirateAlive() + ".");
        System.out.println("There are " + crew.size() + " pirates left.");
    }

    public boolean battle(Ship otherShip) {
        int shipScore = scoreCalculator();
        int otherShipScore = otherShip.scoreCalculator();

        if (shipScore > otherShipScore) {
            victory();
            otherShip.defeat();
            return true;
        } else {
            defeat();
            otherShip.victory();
            return false;
        }
    }

    public int scoreCalculator() {
        return crew.size() - captain.howManyShots();
    }

    public void victory() {
        Random random = new Random();
        int shotsOfRum = random.nextInt(10);

        if (captain != null) {
            captain.drinkSomeRum(shotsOfRum);
        }

        for (Pirate pirate : crew) {
            if (pirate.isAlive()) {
                pirate.drinkSomeRum(shotsOfRum);
            }
        }
    }

    public void defeat() {
        Random random = new Random();
        int piratesToDie = random.nextInt(crew.size() + 1);
        for (int i = 0; i < piratesToDie; i++) {
            int pirateIndex = random.nextInt(crew.size());
            Pirate deadPirate = crew.get(pirateIndex);
            deadPirate.die();
        }

    }
}
