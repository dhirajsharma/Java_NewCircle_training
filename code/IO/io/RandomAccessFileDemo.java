package io;

import java.io.*;

public class RandomAccessFileDemo {

    public static void main(String[] args) throws IOException {
        // open some file in a read/write mode
        RandomAccessFile file = 
            new RandomAccessFile("somefile.dat", "rw");
        try {
            // print the first line of the file
            System.out.println(file.readLine());
            // go to the end of the file
            file.seek(file.length());
            // append some text
            file.writeChars("Append to the end of the file");
        } finally {
            // close the file
            file.close();
        }
    }
}

