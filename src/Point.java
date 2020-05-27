import java.awt.*;
import java.util.Random;

public class Point extends Canvas {
    float x;
    float y;
    int label;

    Point() {
        x = new Random().nextFloat();
        y = new Random().nextFloat();

        if(x > y) {
            label = 1;
        }
        else {
            label = -1;
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gd = (Graphics2D) g;
        if (label == 1) gd.setPaint(new Color(255, 255, 255));
        else gd.setPaint(new Color(0, 0, 0));
        g.fillOval((int)x, (int)y, 16, 16);
    }
}