import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {
        // Write a program prompts the user for 5 integers in a row,
        // then it prints their sum and their average:
        //
        // Please enter a number: 3
        // Please enter a number: 7
        // Please enter a number: 1
        // Please enter a number: 6
        // Please enter a number: 5
        // Sum: 22, Average: 4.4
        //
        Scanner scanner = new Scanner(System.in);
        int numberSum = 0;


        for (int num = 0; num < 5; num++) {
            System.out.println("Please enter a number: ");
            int number = scanner.nextInt();
            numberSum = numberSum + number;


        }
        System.out.println("Sum: " + numberSum + ", Average: " + ((double)numberSum / 5));



    }
}