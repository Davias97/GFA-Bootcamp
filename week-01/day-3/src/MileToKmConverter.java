import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        // Write a program which prompts the user for a double value
        // specifying a distance in miles, converts that value
        // to kilometers and prints it
        //
        // Example:
        //
        // Please enter a distance in miles: 1.8
        // The distance in km: 2.88
        //
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a distance in miles: ");
        double miles = scanner.nextDouble();
        double kilometers = miles * 1.6;
        System.out.println("The distance in km: " + kilometers);

    }
}