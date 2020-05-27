import javax.swing.*;
import java.awt.*;

public class MyPerceptronFactory extends JComponent {
    Perceptron p;

    Point[] points = new Point[500];
    int trainingIndex = 0;

    public void settings() {
        JFrame window = new JFrame();
        window.getContentPane();
        window.setSize(800, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void setup() {
        settings();
        p = new Perceptron();

        for(int i = 0; i < points.length; i++) {
            points[i] = new Point();
        }
    }

    public void draw(Graphics g) {
        Graphics2D gd = (Graphics2D) g;
        paint(g);
        for(Point pt : points) {
            float[] inputs = { pt.x, pt.y};
            int target = pt.label;
            pt.paint(g);
            int guess = p.guess(inputs);
            if(guess == target) gd.setPaint(Color.GREEN);
            else gd.setPaint(Color.RED);
            gd.fillOval((int)pt.x, (int)pt.y, 8, 8);
        }

        Point training = points[trainingIndex];
        float[] inputs = { training.x, training.y};
        int target = training.label;
        p.train(inputs, target);
        trainingIndex++;
        if(trainingIndex == points.length) {
            trainingIndex = 0;
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(30, 20, 80, 90);
    }
}


