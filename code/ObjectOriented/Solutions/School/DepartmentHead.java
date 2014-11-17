public class DepartmentHead extends Teacher {

    private String department;

    public DepartmentHead(String name, String ssn, String department) {
        super(name, ssn);
        this.department = department;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Department: " + this.getDepartment());
    }

}
