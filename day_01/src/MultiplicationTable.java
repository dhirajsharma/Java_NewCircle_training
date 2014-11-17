import java.util.Scanner;

/**
 * Created by toddmcleod on 11/17/14.
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a number for the multiplication table. ");
        int tableNumber = keyboard.nextInt();

//        print table header
        System.out.print("\t");
        for (int i = 0; i <= tableNumber; i++) {
            System.out.print(" " + i + "\t");
        }
        System.out.print("\n\t");
        for (int i = 0; i <= tableNumber; i++) {
            System.out.print("===\t");
        }
//        print table
        System.out.println();
        for (int i = 0; i <= tableNumber; i++) {
            System.out.print(i);
            for (int j = 0; j <= tableNumber; j++) {
                System.out.print("\t " + (i * j));
            }
            System.out.println();
        }
    }
}
