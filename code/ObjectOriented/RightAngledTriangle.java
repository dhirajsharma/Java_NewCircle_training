public class RightAngledTriangle extends Triangle {
  private double a, b, c;
  public RightAngledTriangle(double a, double b) {
    this.a = a;
    this.b = b;
    this.c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
  }
  public double getA() { return a; }
  public double getB() { return b; }
  public double getC() { return c; }
  public double getArea() { return (a * b) / 2; }
}

