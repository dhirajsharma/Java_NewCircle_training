import java.util.Map;

public class PrintEnv {
    public static void main (String[] args) {
        for (Map.Entry e : System.getenv().entrySet()) {
            System.out.println(e);
        }
    }
}
