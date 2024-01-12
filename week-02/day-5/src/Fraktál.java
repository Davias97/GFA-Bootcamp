import javax.swing.*;

import java.awt.*;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Fraktál {
    public static void drawImage(Graphics graphics) {

        drawCross(graphics, 0, 0, WIDTH, HEIGHT);


    }

    public static void drawCross(Graphics graphics, int x, int y, int width, int height) {

        if (Math.min(width, height) < 100) {
            return;
        }

        graphics.drawLine(x + width / 3, y, x + width / 3,y + height);
        graphics.drawLine(x + width * 2/ 3, y, x + width * 2 / 3,y + height);
        graphics.drawLine(x, y + height / 3,x + width , y + height / 3);
        graphics.drawLine(x, y + height * 2 / 3, x + width, y + height * 2 / 3);

        drawCross(graphics, x, y, width / 3, height / 3);
        drawCross(graphics, x + width * 2 / 3, y, width / 3, height / 3);
        drawCross(graphics, x, y, width / 3, height / 3);
        drawCross(graphics, x + width * 2 / 3, height * 2 / 3, width / 3, height / 3);
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