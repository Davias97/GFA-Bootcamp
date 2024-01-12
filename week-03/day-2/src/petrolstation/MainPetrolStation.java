package petrolstation;

public class MainPetrolStation {
    public static void main(String[] args) {

        Station station = new Station();

        Car car = new Car();

        station.refill(car);
        System.out.println("Car Gas Amount: " + car.getGasAmount());

    }
}
