

public class MaximumOperation extends ResultOperation {

    public MaximumOperation() {
        super.result = Double.MIN_VALUE;
    }

    public void calculate(double operand) {
        if (operand > super.result) {
            super.result = operand;
        }
    }
}
