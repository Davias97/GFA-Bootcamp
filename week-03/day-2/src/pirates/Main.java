package pirates;

public class Main {
    public static void main(String[] args) {

        Pirate pirate = new Pirate();
        Ship ship1 = new Ship();
        Ship ship2 = new Ship();
        pirate.pirate();
        ship1.ship();
        ship2.ship();
        ship1.fillShip();
        ship1.getShipInfo();
        ship2.fillShip();
        ship2.getShipInfo();
        ship1.battle(ship2);
        ship1.getShipInfo();
        ship2.getShipInfo();

    }
}
