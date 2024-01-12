import java.util.Scanner;

public class CountFromTo {
    public static void main(String[] args) {
        // Create a program that asks for two numbers. If the second number
        // is not greater than the first the program should print:
        // "The second number should be bigger"
        //
        // Otherwise it should output all integers between the first and
        // the second number (excluding the second number)
        //
        // Example:
        //
        // Please enter the first number: 3
        // Please enter the second number: 6
        // 3
        // 4
        // 5
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the first number: ");
        int userInput1 = scanner.nextInt();
        System.out.print("Please enter the second number: ");
        int userInput2 = scanner.nextInt();


        if (userInput2 <= userInput1) {
            System.out.println("The second number should be bigger");
        } else {
            for (int i = userInput1; i < userInput2; i++) {
                System.out.println(i);
            }
        }
    }
}