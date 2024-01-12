import javax.swing.*;

import java.awt.*;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {
    public static void drawImage(Graphics graphics) {
        // Create a square drawing function that takes 3 parameters
        // (the square size, the fill color and the graphics)
        // and draws a square of that size and color to the center of the canvas.
        // Create a loop that fills the canvas with rainbow colored squares (red, orange, yellow, green, blue, indigo, violet).
        Scanner scanner = new Scanner(System.in);
        System.out.println("Size: ");
        int sizeInput = scanner.nextInt();
        System.out.println("Color: ");
        String colorInput = scanner.nextLine();

        printSquare(graphics, sizeInput, colorInput);
    }

    public static void printSquare(Graphics graphics, int sizeInput, String colorInput) {
    int size = sizeInput;
    String color = colorInput;

      //  graphics.setColor(Color.color);
        graphics.fillRect(WIDTH / 2 - (size/2), HEIGHT / 2 - (size/2), size, size);


    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            drawImage(graphics);
        }
    }
}