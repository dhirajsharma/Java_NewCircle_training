package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * This program compresses one or more input files using gzip compression
 * algorithm. Source files are deleted and compressed files get .gz extension.
 */
public class Gzip {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: Gzip <file>...");
        }
        for (int i = 0; i < args.length; i++) {
            gzip(new File(args[i]));
        }
    }

    private static void gzip(File file) {
        if (!file.exists()) {
            System.err.println("No such file: " + file.getAbsolutePath());
        } else if (file.isDirectory()) {
            System.err.println("Cannot compress directory: "
                    + file.getAbsolutePath());
        } else {
            File outFile = new File(file.getAbsoluteFile() + ".gz");
            try {
                InputStream in = new FileInputStream(file);
                try {
                    OutputStream out = new FileOutputStream(outFile);
                    try {
                        out = new GZIPOutputStream(out);
                        byte[] buffer = new byte[1024];
                        int len = 0;
                        while ((len = in.read(buffer)) > 0) {
                            out.write(buffer, 0, len);
                        }
                    } finally {
                        out.close();
                    }
                } finally {
                    in.close();
                }
                file.delete(); // delete original
            } catch (IOException e) {
                if (outFile.exists()) {
                    outFile.delete();
                }
                System.err.println("Failed to compress "
                        + file.getAbsolutePath() + ": " + e.getMessage());
            }
        }
    }
}

