/**
 * Created by toddmcleod on 11/17/14.
 */
public class loop_break {
    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            if (i == 3)
                break;
            System.out.println("i - " + i);
        }
        System.out.println("************");
        for (int i = 10; i < 20 ; i++) {
            if (i == 13)
                continue;
            System.out.println("i - " + i);
        }
    }
}
