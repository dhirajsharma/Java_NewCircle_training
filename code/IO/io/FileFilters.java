
package io;

import java.io.File;
import java.io.FileFilter;

public class FileFilters {

    private FileFilters() {
    }

    public static FileFilter and(FileFilter... filters) {
        return new AndFileFilter(filters);
    }

    public static FileFilter or(FileFilter... filters) {
        return new OrFileFilter(filters);
    }

    public static FileFilter not(final FileFilter filter) {
        return new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !filter.accept(pathname);
            }
        };
    }

    public static FileFilter ext(final String extension) {
        return new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        };
    }
}
