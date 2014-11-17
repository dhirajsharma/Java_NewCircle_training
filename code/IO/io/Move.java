package io;

import java.io.File;

public class Move {

    public static void main(String[] args) {
        if (args.length >= 1 && args.length <= 2) {
            File source = new File(args[0]);
            File destination = null;
            if (args.length == 2) {
                destination = new File(args[1]);
                if (destination.isDirectory()) {
                    destination = new File(destination, source.getName());
                }
            } else {
                destination = new File(source.getName());
            }
            move(source, destination);
        } else {
            System.err.println("Usage: Move <source> [<destination>]");
        }
    }

    private static void move(File source, File destination) {
        if (!source.exists()) {
            System.err.println("No such file or directory: "
                    + source.getAbsolutePath());
        } else if (source.equals(destination)) {
            System.err.println("Source and destination files must not be the same.");
        } else if (!source.renameTo(destination)) {
            System.err.println("Could not move " + source.getAbsolutePath()
                    + " to " + destination.getAbsolutePath());
        }
    }
}
