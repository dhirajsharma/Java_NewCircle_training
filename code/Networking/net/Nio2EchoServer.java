
package net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Nio2EchoServer implements Runnable {
    private static final Logger logger = Logger.getLogger(Nio2EchoServer.class.getName());

    private final InetSocketAddress inetSocketAddress;

    private AsynchronousServerSocketChannel serverChannel;

    public Nio2EchoServer(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress == null) {
            throw new NullPointerException("Parameter inetSocketAddress must not be null");
        } else if (inetSocketAddress.isUnresolved()) {
            throw new IllegalArgumentException("Unresolved inetSocketAddress: " + inetSocketAddress);
        } else {
            this.inetSocketAddress = inetSocketAddress;
        }
    }

    public void shutdown() {
        if (this.serverChannel != null && this.serverChannel.isOpen()) {
            logger.info("Shutting down");
            try {
                this.serverChannel.close();
            } catch (IOException e) {
                logger.log(Level.WARNING, "Failed to shut-down. Ignoring.", e);
            }
        }
    }

    @Override
    public void run() {
        try {
            this.serverChannel = AsynchronousServerSocketChannel.open();
            this.serverChannel.bind(this.inetSocketAddress);
            logger.info("Accepting connections on " + this.inetSocketAddress);
            this.serverChannel.accept(null,
                    new CompletionHandler<AsynchronousSocketChannel, Void>() {
                        public void completed(final AsynchronousSocketChannel clientChannel,
                                Void att) {
                            // accept the next connection
                            Nio2EchoServer.this.serverChannel.accept(null, this);
                            logger.info("Accepted connection");
                            // handle this connection
                            ByteBuffer buffer = ByteBuffer.allocate(16);
                            logger.info("Initial read");
                            clientChannel.read(buffer, buffer,
                                    new CompletionHandler<Integer, ByteBuffer>() {
                                        @Override
                                        public void completed(Integer numRead, ByteBuffer buffer) {
                                            if (numRead == -1) {
                                                try {
                                                    logger.info("Closing");
                                                    clientChannel.close();
                                                } catch (IOException e) {
                                                    logger.log(Level.WARNING, "Failed on close", e);
                                                }
                                            } else {
                                                logger.info("Read " + numRead
                                                        + " bytes. Initiating write.");
                                                buffer.flip();
                                                clientChannel
                                                        .write(buffer,
                                                                buffer,
                                                                new CompletionHandler<Integer, ByteBuffer>() {
                                                                    @Override
                                                                    public void completed(
                                                                            Integer bytesWritten,
                                                                            ByteBuffer buffer) {

                                                                        if (buffer.hasRemaining()) {
                                                                            logger.info("Wrote "
                                                                                    + bytesWritten
                                                                                    + " bytes. Scheduling write of "
                                                                                    + buffer.remaining()
                                                                                    + " more.");
                                                                            clientChannel.write(
                                                                                    buffer, buffer,
                                                                                    this);
                                                                        } else {
                                                                            logger.info("Done writing "
                                                                                    + bytesWritten
                                                                                    + " bytes");
                                                                        }
                                                                    }

                                                                    @Override
                                                                    public void failed(
                                                                            Throwable exc,
                                                                            ByteBuffer attachment) {
                                                                        logger.log(Level.WARNING,
                                                                                "Failed on write",
                                                                                exc);
                                                                    }

                                                                });
                                                buffer = ByteBuffer.allocate(16);
                                                logger.info("Next read");
                                                clientChannel.read(buffer, buffer, this);
                                            }
                                        }

                                        @Override
                                        public void failed(Throwable exc, ByteBuffer byteBuffer) {
                                            logger.log(Level.WARNING, "Failed on read", exc);
                                        }
                                    });
                        }

                        public void failed(Throwable exc, Void att) {
                            if (exc instanceof AsynchronousCloseException) {
                                logger.info("Shut down");
                            } else {
                                logger.log(Level.WARNING, "Failed on accept", exc);
                            }
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException("Encountered an I/O error. Bailing out.", e);
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("USAGE: Nio2EchoServer [hostname] <port>");
        } else {
            final String hostname = args.length >= 2 ? args[0] : "localhost";
            final int port = Integer.parseInt(args[args.length >= 2 ? 1 : 0]);
            final InetSocketAddress inetSocketAddress = new InetSocketAddress(hostname, port);
            final Nio2EchoServer nioEchoServer = new Nio2EchoServer(inetSocketAddress);
            nioEchoServer.run();
            while (true) {
                String line = System.console().readLine("Type 'shutdown' to shut down> ");
                if (line == null) {
                    System.out.println("Press CTRL+C to shutdown this server");
                    break; // don't shut down
                } else if ("shutdown".equals(line)) {
                    nioEchoServer.shutdown();
                    break;
                }
            }
        }
    }

}
