
package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class RawWebClient {

    public static void main(String[] args) throws NumberFormatException, UnknownHostException,
            IOException {
        try (Socket socket = new Socket(args[0], Integer.parseInt(args[1]))) {
            String request = "GET / HTTP/1.1\r\nHost: " + args[0] + "\r\nConnection: close\r\n\r\n";
            try (OutputStream out = socket.getOutputStream()) {
                out.write(request.getBytes());
                out.flush();
                try (InputStream in = socket.getInputStream()) {
                    byte[] buf = new byte[1024];
                    while (true) {
                        int numRead = in.read(buf);
                        if (numRead < 0) {
                            break;
                        }
                        System.out.write(buf, 0, numRead);
                    }
                }
            }
        }
    }
}
