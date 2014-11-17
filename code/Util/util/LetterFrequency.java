package util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.Map;

/**
 * This program computes the frequency of letters passed to it either as command
 * line arguments or from STDIN. The result is written back to STDOUT.
 * 
 * This demonstrates the use of Maps.
 */
public class LetterFrequency {

    public static void main(String[] args) throws IOException {
        Map<Character,Integer> letterMap = new TreeMap<Character,Integer>();
        if (args.length > 0) {
            for (String arg : args) {
                for (int i = 0; i < arg.length(); i++) {
                    countLetter(letterMap, arg.charAt(i));
                }
            }
        } else {
            InputStreamReader reader = new InputStreamReader(System.in);
            int ch;
            while ((ch = reader.read()) != -1) {
                countLetter(letterMap, (char) ch);
            }
        }
        for (Map.Entry e : letterMap.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    private static void countLetter(Map<Character,Integer> letterMap, char ch) {
        Character letter = Character.valueOf(ch);
        int count = letterMap.containsKey(letter)?
                        letterMap.get(letter) + 1 : 1;
        letterMap.put(letter, count);
    }
}
