public enum CalculationOperation {
  PLUS {
    public double calculate(double x, double y) { return x + y; } 
  },
  MINUS { 
    public double calculate(double x, double y) { return x - y; } 
  },
  MULTIPLY {
    public double calculate(double x, double y) { return x * y; } 
  },
  DIVIDE{
    public double calculate(double x, double y) { return x / y; } 
  };

  public abstract double calculate(double x, double y);
}
