import java.util.Scanner;

public class DrawDiagonal {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input and
        // then draws a square with the main diagonal of the specified size
        //
        // Example:
        //
        // Please enter the square size: 6
        // %%%%%%
        // %%   %
        // % %  %
        // %  % %
        // %   %%
        // %%%%%%
        //
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the square size: ");
        int squareSize = scanner.nextInt();
        draw(squareSize);
    }


    public static void draw(int size) {
        // Write your code to draw a square with the main diagonal here
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || j == 0 || i == size - 1 || j == size - 1 || j == i) {
                    System.out.print("%");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}