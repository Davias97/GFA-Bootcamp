import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {

    public static void drawImage(Graphics graphics) {
        // Draw four different size and color rectangles
        // Avoid code duplication!
        getRect(graphics, 10, 10, 10, 10);
    }


    public static void getRect(Graphics graphics, int x, int y, int w, int h) {


        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int randomColor = random.nextInt(256);
            x = random.nextInt(150);
            y = random.nextInt(150);
            w = random.nextInt(150);
            h = random.nextInt(150);

            Color colorOnRandom = new Color(randomColor);
            graphics.setColor(colorOnRandom);
            graphics.fillRect(x, y, w, h);
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