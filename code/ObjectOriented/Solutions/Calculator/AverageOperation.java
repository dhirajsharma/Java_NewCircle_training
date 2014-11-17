

/**
 * A calculation operation that knows how to average operands.
 */
public class AverageOperation implements Operation {

    private double total = 0;

    private int count = 0;

    public void calculate(double operand) {
        this.total += operand;
        this.count++;

    }

    public double getResult() {
        return this.total / this.count;
    }

}
