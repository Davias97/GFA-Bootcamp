package thegardenapplication;

public class Main {
    public static void main(String[] args) {

        Garden garden = new Garden();

        garden.addPlant(new Flower("yellow"));
        garden.addPlant(new Flower("blue"));
        garden.addPlant(new Tree("purple"));
        garden.addPlant(new Tree("orange"));

        garden.info();
        garden.water(40);
        garden.water(70);

    }
}
