import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MyPerceptron mp = new MyPerceptron();
            mp.setVisible(true);
        });
    }
}
