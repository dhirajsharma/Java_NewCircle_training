public abstract class Person {
    private final String name;

    private int yearOfBirth;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int yearOfBirth) {
        this(name);
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return this.name;
    }

    public void print() {
        System.out.println("Name: " + this.getName());
        System.out.println("Year of birth:  " + this.getYearOfBirth());
    }
}
