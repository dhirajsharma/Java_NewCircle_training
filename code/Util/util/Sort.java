package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This program reads arguments passed to it from the command-line 
 * or the lines from STDIN, sorts them, and writes the result to STDOUT.
 */
public class Sort {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            Arrays.sort(args);
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        } else {
            List lines = new ArrayList();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    System.in));
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            Collections.sort(lines);
            for (Iterator i = lines.iterator(); i.hasNext();) {
                System.out.println(i.next());
            }
        }
    }
}
