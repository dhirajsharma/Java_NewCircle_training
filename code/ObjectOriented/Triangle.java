public abstract class Triangle implements Shape {
  public abstract double getA();
  public abstract double getB();
  public abstract double getC();
  public double getPerimeter() {
    return getA() + getB() + getC();
  }
  // getArea() is also abstract since it is not implemented
}
