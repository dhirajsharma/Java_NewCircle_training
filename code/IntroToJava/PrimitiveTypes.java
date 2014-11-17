public class PrimitiveTypes {
    public static void main(String[] args) {
        boolean flag = false;
        byte b = 0x20;
        short s = 300;
        char c = 'A';
        int i = 4000000;
        long l = 123123123L;
        float f = 123.123f;
        double d = 123123.123;

        s = b;
        i = s;
        i = c;
        l = i;
        f = l;
        d = f;

        double r = d % f;
    }
}
