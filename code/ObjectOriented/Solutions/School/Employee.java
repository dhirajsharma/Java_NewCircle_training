public class Employee extends Person {

    private final String ssn;

    private String emailAddress;

    public Employee(String name, String ssn) {
        super(name);
        this.ssn = ssn;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSsn() {
        return this.ssn;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("SSN: " + this.getSsn());
        System.out.println("Email: " + this.getEmailAddress());
    }

}
