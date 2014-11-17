
package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class Copy {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("USAGE: Copy <source> [destination]");
            return;
        } else {
            FileSystem fileSystem = FileSystems.getDefault();
            Path source = fileSystem.getPath(args[0]);
            Path destination = args.length >= 2 ? fileSystem.getPath(args[1]) : fileSystem.getPath(
                    ".").resolve(source.getFileName());
            int copyAlgorithm = Integer.getInteger("copy.algorithm", 8);
            switch (copyAlgorithm) {
                case 1:
                    copy1(source, destination);
                    break;
                case 2:
                    copy2(source, destination);
                    break;
                case 3:
                    copy3(source, destination);
                    break;
                case 4:
                    copy4(source, destination);
                    break;
                case 5:
                    copy5(source, destination);
                    break;
                case 6:
                    copy6(source, destination);
                    break;
                case 7:
                    copy7(source, destination);
                    break;
                case 8:
                    copy8(source, destination);
                    break;
                default:
                    System.err.println("Bad copy algorithm: " + copyAlgorithm);
            }
        }
    }

    private static void copy1(Path source, Path destination) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(source.toFile());
            out = new FileOutputStream(destination.toFile(), false);
            byte[] buf = new byte[4096];
            for (int numRead; (numRead = in.read(buf)) != -1;) {
                out.write(buf, 0, numRead);
            }
        } finally {
            try {
                if (out != null) {
                    out.close(); // can suppress exceptions
                }
            } finally {
                if (in != null) {
                    in.close(); // can suppress exceptions
                }
            }
        }
    }

    private static void copy2(Path source, Path destination) throws IOException {
        InputStream in = new FileInputStream(source.toFile());
        try {
            OutputStream out = new FileOutputStream(destination.toFile(), false);
            try {
                byte[] buf = new byte[4096];
                for (int numRead; (numRead = in.read(buf)) != -1;) {
                    out.write(buf, 0, numRead);
                }
            } finally {
                out.close(); // can suppress exceptions
            }
        } finally {
            in.close(); // can suppress exceptions
        }
    }

    private static void copy3(Path source, Path destination) throws IOException {
        IOException cause = null;
        try {
            InputStream in = new FileInputStream(source.toFile());
            try {
                OutputStream out = new FileOutputStream(destination.toFile(), false);
                try {
                    byte[] buf = new byte[4096];
                    for (int numRead; (numRead = in.read(buf)) != -1;) {
                        out.write(buf, 0, numRead);
                    }
                } catch (IOException e) {
                    cause = e;
                } finally {
                    out.close();
                }
            } catch (IOException e) {
                if (cause == null) {
                    cause = e;
                }
            } finally {
                in.close();
            }
        } finally {
            if (cause != null) {
                throw cause;
            }
        }
    }

    private static void copy4(Path source, Path destination) throws IOException {
        try (InputStream in = new FileInputStream(source.toFile());
                OutputStream out = new FileOutputStream(destination.toFile(), false)) {
            byte[] buf = new byte[4096];
            for (int numRead; (numRead = in.read(buf)) != -1;) {
                out.write(buf, 0, numRead);
            }
        }
    }

    private static void copy5(Path source, Path destination) throws IOException {
        try (ByteChannel in = Files.newByteChannel(source, StandardOpenOption.READ);
                ByteChannel out = Files.newByteChannel(destination, StandardOpenOption.CREATE,
                        StandardOpenOption.WRITE);) {
            ByteBuffer buf = ByteBuffer.allocate(4096);
            while (in.read(buf) != -1) {
                buf.flip(); // flip for writing
                out.write(buf); // buf already knows how much data it has
                buf.clear(); // clear for fresh reading
            }
        }
    }

    private static void copy6(Path source, Path destination) throws IOException {
        try (InputStream in = Files.newInputStream(source)) {
            Files.copy(in, destination, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private static void copy7(Path source, Path destination) throws IOException {
        try (OutputStream out = Files.newOutputStream(destination)) {
            Files.copy(source, out);
        }
    }

    private static void copy8(Path source, Path destination) throws IOException {
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}
