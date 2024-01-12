import java.util.Scanner;

public class troj {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input and
        // then draws a diamond of the specified height
        //
        // Example:
        //
        // Please enter the diamond height: 4
        //    *
        //   ***
        //  *****
        // *******
        //  *****
        //   ***
        //    *
        //
        // Note: the height of the diamond is taken from its base
        // (where it is the widest) to the top.
        // The total number of lines produced is 2*height-1
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the diamond height: ");
        int height = scanner.nextInt();
        draw(height);
    }

    public static void draw(int size) {
        // Write your code to draw the diamond here

        for (int i = (size - 1); i >= 1; i--) {

            for (int j = 1; j <= size - i; j++)
                System.out.print(" ");

            for (int k = 1; k <= 2 * i - 1; k++)
                System.out.print("*");

            System.out.println();
        }

    }

}

