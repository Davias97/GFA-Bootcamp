import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input and
        // then draws a pyramid of the specified height
        //
        // Example:
        //
        // Please enter the pyramid height: 4
        //    *
        //   ***
        //  *****
        // *******
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the pyramid height: ");
        int height = scanner.nextInt();
        draw(height);

    }

    public static void draw(int height) {
        // Write your code to draw the pyramid here
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height - i; j++)
                System.out.print(" ");

            for (int k = 1; k <= 2 * i - 1; k++)
                System.out.print("*");

            System.out.println();
        }
    }
}
