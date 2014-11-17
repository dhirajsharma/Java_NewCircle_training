package util;

import java.util.Random;

/**
 * This program computes a random string of specified length from alphanumerical
 * characters.
 */
public class Randomize {
    private static final String ALPHABET = "0123456789"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: Randomize <length>");
        } else {
            System.out.println(getRandomString(Integer.parseInt(args[0])));
        }
    }

    private static String getRandomString(int len) {
        char[] out = new char[len];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < len; i++) {
            out[i] = ALPHABET.charAt(random.nextInt(ALPHABET.length()));
        }
        return new String(out);
    }
}
