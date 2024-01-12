import javax.swing.*;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GoToCenter {
    public static void drawImage(Graphics graphics) {
        // Create a function that takes 3 parameters and draws a single line
        // Parameters: the x and y coordinates of the line's starting point and the graphics
        // The function shall draw a line from that point to the center of the canvas
        // Draw at least 3 lines with that function using a loop
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set x: ");
        int x = scanner.nextInt();
        System.out.println("Set y: ");
        int y = scanner.nextInt();
        System.out.println("How many cycles: ");
        int cycles = scanner.nextInt();

        drawLine(graphics, x, y, cycles);

    }

    public static void drawLine(Graphics graphics, int x, int y, int cycles) {

        Random random = new Random();

        for (int i = 0; i < cycles; i++) {

            graphics.drawLine(x, y, WIDTH / 2, HEIGHT / 2);
            x = random.nextInt(320);
            y = random.nextInt(320);
        }

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