

/**
 * Simple factory that gets a calculator from a predefined set of standard
 * calculators: +, -, *, /.
 */
public class StaticOperationFactory implements OperationFactory {

    public Operation getOperation(String name) {
        char operator = name.charAt(0);
        switch (operator) {
            case '+':
                return new AdditionOperation();
            case '-':
                return new SubtractionOperation();
            case '*':
                return new MultiplicationOperation();
            case '/':
                return new DivisionOperation();
            default:
                return null;
        }
    }
}
