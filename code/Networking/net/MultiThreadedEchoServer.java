
package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedEchoServer implements Runnable {
    public static void main(String[] args) throws IOException {
        MultiThreadedEchoServer server = new MultiThreadedEchoServer(Integer.parseInt(args[0]));
        new Thread(server).start();
        server.shutdown();
    }

    private final int port;

    private volatile boolean runFlag = true;

    public MultiThreadedEchoServer(int port) {
        this.port = port;
    }

    public void shutdown() {
        this.runFlag = false;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("Listening on " + port);
            System.out.println("(Control-C to terminate)");
            while (this.runFlag) {
                Socket clientSocket = serverSocket.accept();
                Handler handler = new Handler(clientSocket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                try (InputStream in = socket.getInputStream();
                        OutputStream out = socket.getOutputStream();) {
                    int b;
                    while ((b = in.read()) != -1) {
                        out.write(b);
                    }
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    this.socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
