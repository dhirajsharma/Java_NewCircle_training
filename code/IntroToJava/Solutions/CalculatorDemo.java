public class CalculatorDemo {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: CalculatorDemo <operator> <operand>...");
        }

        char operator = args[0].charAt(0);
        float result = Float.parseFloat(args[1]);
        for (int i = 2; i < args.length; i++) {

            float operand = Float.parseFloat(args[i]);
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
                    result /= operand;
                    break;
                default:
                    System.err.println("Unknown operator: " + operator);
                    return;
            }
        }
        System.out.println(result);
    }
}
