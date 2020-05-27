import javax.swing.*;
import java.awt.*;

public class Surface extends JPanel {

    private void draw(Graphics g) {
        Graphics2D gd = (Graphics2D) g;


     //  gd.setPaint(new Color(0,0,0));

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        gd.setRenderingHints(rh);

        gd.fillOval(270, 130, 50, 50);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
}
