package petrolstation;

public class Station {
    int gasAmount = 1000;

    public void refill(Car car) {
        if (gasAmount >= car.getCapacity() - car.getGasAmount()) {
            gasAmount -= (car.getCapacity() - car.getGasAmount());
            car.setGasAmount(car.getCapacity());
            System.out.println("Car successfully refilled.");
        } else {
            System.out.println("Not enough gas in the station to refill the car.");
        }
    }
}
