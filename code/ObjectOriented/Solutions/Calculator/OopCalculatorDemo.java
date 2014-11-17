

/**
 * Calculator demo program.
 */
public class OopCalculatorDemo {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.err.println("Usage: OopCalculatorDemo <operator> <operand>...");
        } else {
            OperationFactory factory = new FallbackOperationFactory();
            Operation operation = factory.getOperation(args[0]);
            for (int i = 1; i < args.length; i++) {
                operation.calculate(Double.parseDouble(args[i]));
            }
            System.out.println(operation.getResult());
        }
    }
}
