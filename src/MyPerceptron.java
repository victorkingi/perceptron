import javax.swing.*;

public class MyPerceptron extends JFrame {

    MyPerceptron() {
        initUI();
    }

    private void initUI() {
        add(new Execution());

        setTitle("Basic shapes");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}