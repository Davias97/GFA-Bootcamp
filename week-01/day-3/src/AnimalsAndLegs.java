import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        // Write a program that asks for two integers
        // The first represents the number of chickens the farmer has
        // The second represents the number of pigs owned by the farmer
        // Print how many legs all the animals have in total
        //
        // Example
        //
        // Please enter the number of chickens: 4
        // Please enter the number of pigs: 2
        // The number of legs: 16
        //
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of chickens: ");
        int chickens = scanner.nextInt();

        System.out.println("Please enter the number of pigs: ");
        int pigs = scanner.nextInt();

        System.out.println("The number of legs: " + ((chickens * 2) + (pigs * 4)));

    }
}