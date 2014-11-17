public class Person {
    private String name;
    private final int yearOfBirth;
    private String emailAddress;

    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress() {
        this.emailAddress = emailAddress;
    }

    public boolean equals(Object o) {
        if (o == this) {
            // we are being compared to ourself
            return true;
        } else if (o == null || o.getClass() != this.getClass()) {
            // can only compare to another person
            return false;
        } else {
            Person p = (Person) o; // cast to our type
            // compare significant fields
            return p.name.equals(this.name) &&
                p.yearOfBirth == this.yearOfBirth;
        }
    }

    public int hashCode() {
        // compute based on significant fields
        return 3 * this.name.hashCode() + 5 * this.yearOfBirth;
    }
}
