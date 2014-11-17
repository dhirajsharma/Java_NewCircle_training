
package io;

import java.io.File;
import java.io.FileFilter;
import static io.FileFilters.*;

public class List {

    public static void main(String[] args) {
        boolean not = Boolean.getBoolean("list.filter.not");
        FileFilter filter = and(RegularFileFilter.getIntance(),
                or(ext(".jpg"), ext(".jpeg"), ext(".png"), ext(".gif")));
        if (not) {
            filter = not(filter);
        }
        if (args.length == 0) {
            list(new File("."), filter);
        } else {
            for (int i = 0; i < args.length; i++) {
                list(new File(args[i]), filter);
            }
        }
    }

    private static void list(File file, FileFilter filter) {
        if (file.isDirectory()) {
            File[] files = file.listFiles(filter);
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
            }
        } else {
            System.out.println(file.getAbsolutePath());
        }
    }
}
