
package io;

import java.io.File;
import java.io.FileFilter;

public class RegularFileFilter implements FileFilter {

    private static final FileFilter INSTANCE = new RegularFileFilter();

    public static FileFilter getIntance() {
        return INSTANCE;
    }

    private RegularFileFilter() {

    }

    @Override
    public boolean accept(File pathname) {
        return pathname.isFile() && pathname.canRead();
    }
}
