public class Bitwise {
    public static void main(String args[]) {
        if (args.length != 2) {
            System.err.println("Usage: Bitwise <x> <y>");
            return;
        }
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        print("x", x);
        print("y", y); 

        print("~x", ~x);
        print("x & y", x & y);
        print("x | y", x | y);
        print("x ^ y", x ^ y);
        print("x >> y", x >> y);
        print("x >>> y", x >>> y);
        print("x << y", x <<  y);
        
        long l1 = 500;
        long l2 = ~l1;
        System.out.println(l2);
    }

    private static void print(String operation, int i) {
        System.out.println(operation + " = " + i + " = " + Integer.toBinaryString(i));
    }
}
