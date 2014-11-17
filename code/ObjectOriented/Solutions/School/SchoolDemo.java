public class SchoolDemo {

    public static void main(String[] args) {
        Person p = new Employee("John", "555-12-1234");
        p.setYearOfBirth(1950);
        p.print();

        Teacher t = new Teacher("Bob", "555-12-1234");
        t.setClasses(new String[] { "Math", "CompSci" });
        t.print();

        Student s = new Student("Tom", 1990, 123456);
        s.setGrade(9);
        s.doHomework();
        s.print();
    }

}
