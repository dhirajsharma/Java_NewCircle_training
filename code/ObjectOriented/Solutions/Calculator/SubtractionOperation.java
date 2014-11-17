

/**
 * A calculation operation that knows how to subtract operands.
 */
public class SubtractionOperation extends InitializableOperation {

    @Override
    protected double calculate(double operand1, double operand2) {
        return operand1 - operand2;
    }
}
