public class ObjectEquality {
    public static void main(String[] args) {
        int i1 = 123;
        int i2 = 123;
        System.out.println(i1 == i2);

        // demonstration only (do not use this constructor)
        String s1 = new String("my string");
        String s2 = new String("my string");
        System.out.println(s1 == s2);

        System.out.println(s1.equals(s2));
    }
}
