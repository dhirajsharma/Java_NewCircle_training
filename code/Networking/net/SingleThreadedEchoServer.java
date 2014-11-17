
package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedEchoServer {
    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(args[0]);
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("Listening on port " + port);
            System.out.println("(Control-C to terminate)");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();) {
                    try (InputStream in = clientSocket.getInputStream();
                            OutputStream out = clientSocket.getOutputStream()) {
                        int b;
                        while ((b = in.read()) != -1) {
                            out.write(b);
                        }
                        out.flush();
                    }
                }
            }
        }
    }
}
