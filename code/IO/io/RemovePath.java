
package io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class RemovePath {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Usage: Remove <file|directory>...");
        }
        FileSystem fileSystem = FileSystems.getDefault();
        for (int i = 0; i < args.length; i++) {
            remove(fileSystem.getPath(args[i]));
        }
    }

    private static void remove(Path path) throws IOException {
        if (!Files.exists(path)) {
            System.err.println("No such file or directory: " + path.toAbsolutePath());
        } else if (Files.isDirectory(path) && hasFiles(path)) {
            System.err.println("Directory contains files: " + path.toAbsolutePath());
        } else {
            try {
                Files.delete(path);
            } catch (IOException e) {
                System.err.println("Could not remove: " + path.toAbsolutePath());
            }
        }
    }

    private static boolean hasFiles(Path dir) throws IOException {
        DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
        try {
            return stream.iterator().hasNext();
        } finally {
            stream.close();
        }
    }
}
