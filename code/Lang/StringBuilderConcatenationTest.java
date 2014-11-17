public class StringBuilderConcatenationTest {
    public static void main (String args[]) {
        final int count = Integer.parseInt(args[0]);
        StringBuilder sb = new StringBuilder();
        long time = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            sb.append(".");
        }
        sb.trimToSize();
        time = System.currentTimeMillis() - time;
        System.out.println(time);
    }
}
