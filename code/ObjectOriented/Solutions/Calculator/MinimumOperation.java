

public class MinimumOperation extends ResultOperation {

    public MinimumOperation() {
        super.result = Double.MAX_VALUE;
    }

    public void calculate(double operand) {
        if (operand < super.result) {
            super.result = operand;
        }
    }
}
