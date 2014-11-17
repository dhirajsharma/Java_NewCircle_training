class C extends B {
    String c = null;
    void doA() {
        System.out.println("Who cares what A says");
    }
    void doB() {
        System.out.println("Who cares what B says");
    }
    void doC() {
        System.out.println("C says " + a + " " + b + " " + c);
    }
}
