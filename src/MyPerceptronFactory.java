import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Random;

public class MyPerceptronFactory extends JPanel {
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

    public void draw() {
        JLabel label = new JLabel();
        label.setBackground(Color.white);
       // line(0, 0, width, height);
        //draw line
        for(Point pt : points) {
            float[] inputs = { pt.x, pt.y};
            int target = pt.label;
            pt.show();
            int guess = p.guess(inputs);
            if(guess == target) {
               // fill(0, 255, 0);
                //fill green
            } else {
                //fill(255, 0, 0);
                //fill red
            }
           // ellipse(pt.x, pt.y, 8, 8);
            //draw ellipse
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
}


