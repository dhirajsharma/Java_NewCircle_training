public abstract class NamedShape implements Shape {
    protected String name;

    public NamedShape(String name) {
        this.name = name;
    }

    public abstract String getDefaultName();

    public String getName() {
        return this.name==null? this.getDefaultName() : this.name;
    }
}
