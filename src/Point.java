import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Point extends JPanel {
    private final int x;
    private final int y;
    private final int label;

    Point() {
        x = new Random().nextInt(800);
        y = new Random().nextInt(800);
        if( x > y) label = 1;
        else label = -1;
    }

    @Override public int getX() { return x; }
    @Override public int getY() { return y; }
    public int getLabel() { return label; }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(final Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        if (label == 1) g2d.setPaint(Color.WHITE);
        else if (label == -1) g2d.setPaint(Color.BLACK);
        g2d.fillOval(x, y, 32, 32);
    }
}
