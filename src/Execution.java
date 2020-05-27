import javax.swing.*;
import java.awt.*;

class Execution extends JPanel {
    private final Perceptron p;
    private final Point[] points;
    private int tIndex;

    Execution() {
        p = new Perceptron();
        points = new Point[200];
        tIndex = 0;
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point();
        }
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        line(g2d);
        for (Point pt : points) {
            pt.paintComponent(g);
        }
        for (Point pt : points) {
            float[] inputs = {pt.getX(), pt.getY()};
            int target = pt.getLabel();
            int guess = p.guess(inputs);
            if(guess == target) g2d.setPaint(Color.GREEN);
            else g2d.setPaint(Color.RED);
            g2d.fillOval(pt.getX(), pt.getY(), 16, 16);
        }
        myTrain();
    }

    private void myTrain() {
        Point training = points[tIndex];
        float[] inputs = {training.getX(), training.getY()};
        int target = training.getLabel();
        p.train(inputs, target);
        tIndex++;
        if(tIndex == points.length - 1) tIndex = 0;
    }

    private void line(Graphics2D g2d) {
        g2d.setPaint(new Color(0, 0, 0));
        g2d.drawLine(0, 0, 800, 800);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}