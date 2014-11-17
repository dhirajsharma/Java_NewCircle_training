/**
 * Created by toddmcleod on 11/17/14.
 */
public class CommandLineStrings {
    public static void main(String[] args) {
        try {
            String myString = args[0];
            System.out.println(myString);
            System.out.println(myString.length());
            System.out.println(myString.toUpperCase());
            System.out.println(myString.toLowerCase());
            System.out.println("*************");
            System.out.printf("%d\n", myString.length());
            System.out.printf("%s\n", myString.toUpperCase());
            System.out.printf("%s\n", myString.toLowerCase());
            if (myString.length() >= 4) {
                System.out.println(myString.substring(0,4));
                System.out.println("*************");
                System.out.printf("%s\n", myString.substring(0,4));
            } else {
                System.out.println(myString);
            }
        } catch (Exception e) {
            System.err.println("Usage: java CommandLineStrings <somestring>");
        }
    }
}
