import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class StoreEmployee {
    public static void main (String[] args) throws IOException {
        if (args.length != 6) {
            System.err.println("Usage: StoreEmployee <name> <ssn> <email> <yob> <extra> <file>");
            return;
        }
        Employee e = new Employee(args[0], args[1], args[2]);
        e.setYearOfBirth(Integer.parseInt(args[3]));
        e.setExtraVacationDays(Integer.parseInt(args[4]));
        
        ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(args[5]));
        try {
            oos.writeObject(e);
        } finally {
            oos.close();
        }
    }
}
