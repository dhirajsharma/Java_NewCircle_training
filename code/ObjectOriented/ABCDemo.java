public class ABCDemo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        a.a = "AAA";
        b.a = "B's A";
        b.b = "BBB";
        c.a = "Who cares";
        c.b = "Whatever";
        c.c = "CCC";

        a.doA();
        b.doB();
        c.doA();
        c.doB();
        c.doC();
    }
}
