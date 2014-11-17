
package io;

import java.io.File;
import java.io.FileFilter;

public class ImageFileFilter implements FileFilter {

    private static final String[] EXTENSIONS = {
            ".gif", ".png", ".jpeg", ".jpg"
    };

    @Override
    public boolean accept(File pathname) {
        if (pathname.isFile()) {
            String name = pathname.getName();
            for (String ext : EXTENSIONS) {
                if (name.endsWith(ext)) {
                    return true;
                }
            }
        }
        return false;
    }

}
