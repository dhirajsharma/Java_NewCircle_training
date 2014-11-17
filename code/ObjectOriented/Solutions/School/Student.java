public class Student extends Person {

    private final int id;

    private int grade;

    private float gpa;

    public Student(String name, int yearOfBirth, int id) {
        super(name, yearOfBirth);
        this.id = id;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public float getGpa() {
        return this.gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getId() {
        return this.id;
    }

    public void goToSchool() {
        System.out.println("Going to school");
    }

    public void doHomework() {
        System.out.println("Doing homework");
    }

    @Override
    public void print() {
        super.print();
        System.out.println("ID: " + this.getId());
        System.out.println("Grade: " + this.getGrade());
        System.out.println("GPA: " + this.getGpa());
    }
}
