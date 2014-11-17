public class ShapeDemo {
    public static void main(String[] args) {
        Circle c = new Circle(5.0);
        Rectangle r = new Rectangle(3, 4);
        Square s = new Square(6);

        ShapePrinter printer = new ShapePrinter();
        printer.print(c);
        printer.print(r);
        printer.print(s);

    }
}
