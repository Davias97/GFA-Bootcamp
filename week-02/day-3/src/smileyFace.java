import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class smileyFace {




    public static void drawImage(Graphics2D graphics) {
        // Draw a box that has different colored lines on each edge
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,WIDTH,HEIGHT);
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(50,50,225,225);
        graphics.setStroke(new BasicStroke(6));
        graphics.setColor(Color.BLACK);
        graphics.fillOval(122,110, 20,40);
        graphics.fillOval(183,110, 20,40);
        graphics.drawArc(82,140,160,100,180,180);




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
            drawImage((Graphics2D) graphics);
        }
    }
}