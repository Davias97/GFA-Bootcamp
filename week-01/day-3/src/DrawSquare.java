import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input and
        // then draws a square of the specified size
        //
        // Example:
        //
        // Please enter the square size: 6
        // %%%%%%
        // %    %
        // %    %
        // %    %
        // %    %
        // %%%%%%
        //


        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the square size: ");
        int squareSize = scanner.nextInt();
        draw(squareSize);
    }


    public static void draw(int size) {
        // Write your code to draw the square here
        for (int i = 0; i < size; i++) {
            System.out.print("%");
        }
        System.out.println();
        for (int i = 0; i < size - 2; i++) {
            System.out.print("%");
            for (int j = 0; j < size - 2; j++) {
                System.out.print(" ");
            }
            System.out.println("%");
        }
        for (int i = 0; i < size; i++) {
            System.out.print("%");
        }
        System.out.println();
    }
}
