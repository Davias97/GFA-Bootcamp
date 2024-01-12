import javax.swing.*;

import java.awt.*;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Diagonals {
    public static void drawImage(Graphics graphics) {
        // Create a function that draws a single line
        // Use this function to draw the canvas' diagonals
        // If the line starts from the upper-left corner it should be green, otherwise it should be red
        // Make decision about the color in the function
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set x: ");
        int x = scanner.nextInt();
        System.out.println("Set y: ");
        int y = scanner.nextInt();
        System.out.println("Set x2: ");
        int x2 = scanner.nextInt();
        System.out.println("Set y2: ");
        int y2 = scanner.nextInt();

        drawLine(graphics, x, y, x2, y2);


    }

    public static void drawLine(Graphics graphics, int x, int y, int x2, int y2) {



        if (x<x2 && y<y2) {
            graphics.setColor(Color.GREEN);

        }else
            graphics.setColor(Color.RED);

        graphics.drawLine(x, y, x2, y2);


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