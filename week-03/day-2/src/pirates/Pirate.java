package pirates;

import java.util.Random;

public class Pirate {

    private int intoxicated;
    private boolean isAlive;

    public void pirate() {
        this.intoxicated = 0;
        this.isAlive = true;
    }

    public void drinkSomeRum() {
        if (isAlive) {
            this.intoxicated += 1;
        } else {
            System.out.println("He's dead.");
        }
    }

    public void drinkSomeRum(int howManyShots) {
        for (int i = 0; i < howManyShots; i++) {
            if (isAlive) {
                this.intoxicated += 1;
            } else {
                System.out.println("He's dead.");
            }
        }
    }

    public int howManyShots() {
        return this.intoxicated;
    }

    public String isPirateAlive() {
        if (isAlive) {
            return "alive";
        } else
            return "dead";
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void howsItGoingMate() {
        if (isAlive) {
            if (this.intoxicated < 4) {
                System.out.println("Pour me anudder!");
            } else {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
                this.intoxicated = 0;
            }
        } else
            System.out.println("He's dead.");
    }

    public void brawl(Pirate pirate) {
        if (isAlive && pirate.isAlive) {
            Random random = new Random();
            int randomNumber = random.nextInt(3);
            if (randomNumber == 0) {
                die();
                System.out.println("The Pirate died!");
            } else if (randomNumber == 1) {
                pirate.die();
                System.out.println("The other Pirate died!");
            } else
                System.out.println("Both pirates passed out!");
        } else {
            System.out.println("He's dead.");
        }
    }

    public void die() {
        this.isAlive = false;
    }
}

