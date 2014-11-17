

/**
 * An operation that knows how to add operands.
 */
public class AdditionOperation extends ResultOperation {

    public void calculate(double operand) {
        this.result += operand;
    }
}
