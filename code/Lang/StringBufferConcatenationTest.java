public class StringBufferConcatenationTest {
    public static void main (String args[]) {
        final int count = Integer.parseInt(args[0]);
        StringBuffer sb = new StringBuffer();
        long time = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            sb.append(".");
        }
        sb.trimToSize();
        time = System.currentTimeMillis() - time;
        System.out.println(time);
    }
}
