

/**
 * Definition of a calculation operation.
 */
public interface Operation {

    /**
     * Perform a calculation with a single operand.
     * 
     * @param operand the operand used for calculation.
     */
    public void calculate(double operand);

    /**
     * Get the final result of the calculation.
     * 
     * @return the result of the calculation.
     */
    public double getResult();
}
