

/**
 * Simple calculator application.
 * 
 * @author sasa
 * @version 1.0
 */
public class SimpleCalculator {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: SimpleCalculator <operator> <operand>...");
            System.exit(-1);
        }
        char operator = args[0].charAt(0);
        double result = Double.parseDouble(args[1]);
        for (int i = 2; i < args.length; i++) {
            double operand = Double.parseDouble(args[i]);
            switch (operator) {
                case '+':
                    result += operand;
                    break;
                case '-':
                    result -= operand;
                    break;
                case '*':
                    result *= operand;
                    break;
                case '/':
                    if (operand == 0) {
                        System.err.println("Cannot divide by zero!");
                        System.exit(-1);
                    }
                    result /= operand;
                    break;
                default:
                    System.err.println("Invalid operator '" + operator
                            + "'. Valid options are: +, -, *, /");
                    System.exit(-1);
            }
        }
        System.out.println(result);
    }
}
