public class DoWhileArguments {
    public static void main (String[] args) {
        int i = 0;
        do {
            System.out.println(args[i]);
            i += 1;
        } while (i < args.length); 
    }
}
