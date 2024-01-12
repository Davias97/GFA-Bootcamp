import javax.swing.*;

import java.awt.*;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
    public static void drawImage(Graphics graphics) {

        graphics.drawLine(0, HEIGHT, WIDTH , HEIGHT);
        drawLine(graphics);
    }

    public static void drawLine(Graphics graphics) {
        int x = 0;
        int y = 0;
        int howManyLines = 15;

        graphics.setColor(Color.BLACK);
        for (int i = 0; i <= howManyLines; i++) {


            graphics.drawLine(x+x, HEIGHT, WIDTH / 2 + x, y + y);
            graphics.drawLine(WIDTH / 2 - x, y +y, WIDTH / 2 + x, y + y);
            graphics.drawLine((WIDTH - 2*x) , HEIGHT, WIDTH / 2 - x, y + y);



            x = x + (WIDTH / howManyLines) / 2;
            y = y + (HEIGHT / howManyLines) / 2;


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