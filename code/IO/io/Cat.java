
package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * This program reads files specified on the command line and writes their
 * contents to STDOUT. If no files are specified, this program reads from STDIN
 * and writes to STDOUT.
 */
public class Cat {
    public static void main(String[] args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                readDefault(new File(args[i]));
            }
        } else {
            echo();
        }
    }

    static void read(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            try {
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = fis.read(buffer)) > 0) {
                    System.out.write(buffer, 0, len);
                }
            } finally {
                fis.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("No such file exists: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Cannot read file: " + file.getAbsolutePath() + ": "
                    + e.getMessage());
        }
    }

    static void readUTF8(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
            try {
                OutputStreamWriter writer = new OutputStreamWriter(System.out, "UTF-8");
                int ch;
                while ((ch = reader.read()) != -1) {
                    writer.write(ch);
                }
                writer.flush();
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("No such file exists: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Cannot read file: " + file.getAbsolutePath() + ": "
                    + e.getMessage());
        }
    }

    static void readDefault(File file) {
        try {
            FileReader reader = new FileReader(file);
            try {
                int ch;
                while ((ch = reader.read()) != -1) {
                    System.out.print((char) ch);
                }
                System.out.flush();
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("No such file exists: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Cannot read file: " + file.getAbsolutePath() + ": "
                    + e.getMessage());
        }
    }

    private static void echo() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error while echoing STDIN to STDOUT: " + e.getMessage());
        }
    }
}
