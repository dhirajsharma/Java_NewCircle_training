

/**
 * An operation that knows how to multiply operands.
 */
public class MultiplicationOperation extends ResultOperation {

    public MultiplicationOperation() {
        super.result = 1;
    }

    public void calculate(double operand) {
        this.result *= operand;

    }
}
