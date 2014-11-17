package util;

import java.util.StringTokenizer;

/**
 * This program tokenizes input string into delimiter-separated tokens which it
 * prints to STDOUT.
 */
public class Tokenize {

    public static void main(String[] args) {
        if (args.length >= 1 && args.length <= 2) {
            StringTokenizer st = new StringTokenizer(args[0],
                    args.length == 2 ? args[1] : ",");
            while (st.hasMoreTokens()) {
                System.out.println(st.nextToken());
            }
        } else {
            System.err.println("Usage: Tokenize <list> [<delimiter>]");
        }
    }
}
