import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Perceptron {
    private final float[] weights;
    private final float lr;

    Perceptron() {
        weights = new float[2];
        lr = 0.1f;
        List<Integer> random = new ArrayList<>();
        random.add(-1);
        random.add(1);
        for (int i = 0; i < weights.length; i++) {
            weights[i] = random.get(new Random().nextInt(random.size()));
        }
    }
    private int sign(final float n) {
        if (n >= 0) {
            return 1;
        } else {
            return -1;
        }

    }

    protected int guess(final float[] inputs) {
        float sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += inputs[i] * weights[i];
        }
        return sign(sum);
    }

    protected void train(final float[] inputs, final int target) {
        int guess = guess(inputs);
        int error = target - guess;

        for (int i = 0; i < weights.length; i++) {
            weights[i] += error * inputs[i] * lr;
        }
    }
}
