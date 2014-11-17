public class Teacher extends Employee {

    private String[] classes;

    public Teacher(String name, String ssn) {
        super(name, ssn);
    }

    public String[] getClasses() {
        return this.classes;
    }

    public void setClasses(String[] classes) {
        this.classes = classes;
    }

    public void teach(String classToTeach) {
        System.out.println("Teaching " + classToTeach);
    }

    @Override
    public void print() {
        super.print();
        System.out.print("Classes:");
        for (String classToTeach : this.getClasses()) {
            System.out.print(" " + classToTeach);
        }
        System.out.println();
        // or do: java.util.Arrays.toString(this.getClasses());
    }
}
