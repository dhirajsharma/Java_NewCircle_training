/**
 * Simple calculator operation.
 * @author <a href="mailto:me@my.com">Me</a>
 * @version 1.0
 */
public interface Operation {
    /**
     * Perform a single calculation.
     * @param operand the operand to use for calculation.
     */
    public void calculate(double operand);

    /**
     * Get the current result.
     * @return the current result. If no calculations were
     *          performed the result is undefined.
     */
    public double getResult();
}
