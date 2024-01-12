import javax.swing.*;

import java.awt.*;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
    public static void drawImage(Graphics graphics){


    drawLine(graphics);
    }

    public static void drawLine(Graphics graphics) {
    int x = 0;
    int y = 0;
    int x2 = 0;
    int y2 = 0;



        for (int i = 1; i <= 15; i++) {

            graphics.setColor(Color.MAGENTA);
            graphics.drawLine(x , 0, WIDTH , y2);
            x = x + (WIDTH / 15);
            y2 = y2 + (HEIGHT / 15);

        }

        for (int i = 1; i <= 15; i++) {

            graphics.setColor(Color.GREEN);
            graphics.drawLine(0,y,x2, HEIGHT);
            y = y + (HEIGHT / 15);
            x2 = x2 + (WIDTH / 15);
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