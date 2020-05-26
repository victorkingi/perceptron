import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Perceptron {
    float[] weights = new float[2];
    float lr = 0.1f;

    Perceptron() {
        for (int i = 0; i < weights.length; i++) {
            List<Integer> random = new ArrayList<>();
            random.add(-1);
            random.add(1);
            weights[i] = random.get(new Random().nextInt(random.size()));
        }
    }
    public int sign(float n) {
        if (n >= 0) {
            return 1;
        } else {
            return -1;
        }

    }

    public int guess(float[] inputs) {
        float sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += inputs[i] * weights[i];
        }
        int output = sign(sum);
        return output;
    }

    public void train(float[] inputs, int target) {
        int guess = guess(inputs);
        int error = target - guess;

        for (int i = 0; i < weights.length; i++) {
            weights[i] += error * inputs[i] * lr;
        }
    }
}
