public class StringConcatenationTest {
    public static void main (String args[]) {
        final int count = Integer.parseInt(args[0]);
        String s = "";
        long time = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            s += ".";
        }
        time = System.currentTimeMillis() - time;
        System.out.println(time);
    }
}
