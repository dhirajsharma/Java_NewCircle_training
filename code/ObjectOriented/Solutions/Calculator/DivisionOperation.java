

/**
 * A calculator operation that knows how to do divisions.
 */
public class DivisionOperation extends InitializableOperation {

    @Override
    protected double calculate(double operand1, double operand2) {
        return operand1 / operand2;
    }
}
