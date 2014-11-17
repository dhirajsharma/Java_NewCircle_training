import java.util.*;

public class EmployeePrinter {
    public static void main(String[] args) {
        new EmployeePrinter().blah();
    }

    public void blah() {
        List<Manager> list = new LinkedList<Manager>();
        list.add(new Manager("John", "555-12-1234", "DEV"));
        list.add(new Manager("Tom", "111-12-1234", "QA"));
        printAll(list);
    }

    public void printAll(Collection<? extends Employee> employees) {
        for (Iterator<? extends Employee> i = employees.iterator(); i.hasNext(); ) {
            Employee e = i.next();
            e.print();
        }
    }

    public void mapEmployees() {
        Employee e = new Employee("John", "555-12-1234");
        Map<String, Employee> map = new HashMap <String, Employee>();
        map.put(e.getSsn(), e);
        Manager m = new Manager("Tom", "111-12-1234", "QA");
        map.put(m.getSsn(), m);
        Employee e2 = map.get("555-12-1234");

    }
}
