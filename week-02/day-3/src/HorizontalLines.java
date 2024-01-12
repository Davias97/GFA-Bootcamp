import javax.swing.*;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HorizontalLines {
    public static void drawImage(Graphics graphics) {
        // Create a function that takes 3 parameters and draws a single line
        // Parameters: the x and y coordinates of the line's starting point and the graphics
        // The function shall draw a 50-pixel long horizontal line from that point
        // Draw at least 3 lines with that function using a loop
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set x: ");
        int x = scanner.nextInt();
        System.out.println("Set y: ");
        int y = scanner.nextInt();
        System.out.println("How many cycles: ");
        int cycle = scanner.nextInt();

        drawLine(graphics, x, y, cycle);
    }

    public static void drawLine(Graphics graphics, int x, int y, int cycle) {

        Random random = new Random();

        for (int i = 0; i < cycle; i++) {

            graphics.drawLine(x, y, x+50, y);
            x = random.nextInt(270);
            y = random.nextInt(270);

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