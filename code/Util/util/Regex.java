package util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(args[0]);
        Matcher matcher = pattern.matcher(args[1]);
        if (matcher.matches()) {
            for (int g = 0; g <= matcher.groupCount(); g++) {
                System.out.println(g + ": " + matcher.group(g));
            }
        }
    }
}
