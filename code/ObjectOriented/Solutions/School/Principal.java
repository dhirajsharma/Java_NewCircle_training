public class Principal extends Employee {

    private String school;

    public Principal(String name, String ssn) {
        super(name, ssn);
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("School: " + this.getSchool());
    }
}
