

/**
 * An abstract operation that requires initialization of the result 
 * by the first operand.
 */
public abstract class InitializableOperation extends ResultOperation {

    private boolean initialized = false;

    /**
     * Perform a calculation operation on two operands.
     * 
     * @param operand1 the first operand
     * @param operand1 the second operand
     * @return the result of the calculation
     */
    protected abstract double calculate(double operand1, double operand2);

    public final void calculate(double operand) {
        if (this.initialized) {
            this.result = this.calculate(this.result, operand);
        } else {
            this.initialized = true;
            this.result = operand;
        }
    }
}
