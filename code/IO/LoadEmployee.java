import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadEmployee {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: LoadEmployee <file>");
            return;
        }
        ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(args[0]));
        try {
            Employee e = (Employee) ois.readObject();
            e.print();
        } finally {
            ois.close();
        }
    }

}
