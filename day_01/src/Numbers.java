/**
 * Created by toddmcleod on 11/17/14.
 */
public class Numbers {
    public static void main(String[] args) {
        int intSizeInBits = 32;
        int i = intSizeInBits++;
        System.out.println(i);
        i = ++intSizeInBits;
        System.out.println("*******");
        System.out.println(i);
    }
}
