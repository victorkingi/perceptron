import java.util.Random;

public class Point {
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

    public void show() {
        if(label == 1) {
           // fill(255);
            //fill white
        } else {
            //fill(0);
            // fill black
        }
        //ellipse(x, y, 16, 16);
        //draw ellipse
    }
}