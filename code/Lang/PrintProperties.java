import java.util.Map;

public class PrintProperties {
    public static void main (String[] args) {
        for (Map.Entry e : System.getProperties().entrySet()) {
            System.out.println(e);
        }
    }
}
