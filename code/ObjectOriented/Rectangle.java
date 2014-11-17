/**
 * Rectange shape with a width and a height.
 * @author sasa
 * @version 1.0
 */
public class Rectangle implements Shape {

    private double width;
    private double height;

    /**
     * Constructor.
     * @param width the width of this rectangle.
     * @param height the height of this rectangle.
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the width.
     * @return the width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets the height.
     * @return the height.
     */
    public double getHeight() {
        return height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }
}
