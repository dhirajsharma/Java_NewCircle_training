package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * This program computes a unique set of elements passed to it either from
 * command line (as arguments) or from STDIN (as lines).
 * 
 * This demonstrates the use of Sets.
 */
public class Unique {

    public static void main(String[] args) throws IOException {
        Set unique = new HashSet(); // replace with TreeSet to get them sorted
        if (args.length > 0) {
            unique.addAll(Arrays.asList(args));
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    System.in));
            String line = null;
            while ((line = reader.readLine()) != null) {
                unique.add(line);
            }
        }
        for (Iterator i = unique.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
    }
}
