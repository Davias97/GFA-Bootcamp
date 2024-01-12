import javax.swing.*;

import java.awt.*;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {
    public static void drawImage(Graphics graphics) {


        drawLine(graphics);
    }

    public static void drawLine(Graphics graphics) {
        int x = 0;
        int y2 = 0;
        int howManyLines = 16;

        graphics.setColor(Color.GREEN);
        for (int i = 1; i <= howManyLines; i++) {


            graphics.drawLine(x, HEIGHT / 2, WIDTH / 2, HEIGHT / 2 + y2);
            graphics.drawLine(x, HEIGHT / 2, WIDTH / 2, HEIGHT / 2 - y2);
            graphics.drawLine(WIDTH - x, HEIGHT / 2, WIDTH / 2, HEIGHT / 2 - y2);
            graphics.drawLine(WIDTH - x, HEIGHT / 2, WIDTH / 2, HEIGHT / 2 + y2);
            x = x + (WIDTH / howManyLines / 2);
            y2 = y2 + (HEIGHT / howManyLines / 2);

        }

//        for (int i = 1; i <= 16; i++) {
//
//
//            graphics.drawLine(x, HEIGHT / 2, WIDTH / 2, HEIGHT / 2 - y2);
//            x = x + (WIDTH / 16 / 2);
//            y2 = y2 + (HEIGHT / 16 / 2);
//        }

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