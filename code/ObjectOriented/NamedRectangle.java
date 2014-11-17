public class NamedRectangle extends NamedShape {
    private double w;
    private double h;

    public NamedRectangle(String name, double w, double h) {
        super(name);
        this.w = w;
        this.h = h;
    }
  
    public double getArea() { 
        return w * h; 
    }
    
    public double getCircumference() { 
        return 2 * (w + h); 
    }
    
    public String getDefaultName() { 
        return "Rectangle"; 
    }
}
