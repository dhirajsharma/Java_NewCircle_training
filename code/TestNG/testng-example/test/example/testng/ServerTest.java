package example.testng;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Simple test class that demonstrates the use of Before and After 
 * annotations.
 */
public class ServerTest {
    private Socket socket;

    private InputStream in;

    private OutputStream out;

    @BeforeClass
    public void connectToServer() throws IOException {
        this.socket = new Socket("some.host.com", 4567);
        this.in = this.socket.getInputStream();
        this.out = this.socket.getOutputStream();
    }

    @BeforeTest
    public void loginToServer() throws IOException {
        this.out.write("LOGIN user/password\r\n".getBytes());
    }

    @Test
    public void testOnServer1() {
        // execute test1 over the logged in connection
    }

    @Test
    public void testOnServer2() {
        // execute test2 over the logged in connection
    }

    @Test
    public void testOnServer3() {
        // execute test3 over the logged in connection
    }

    @AfterTest
    public void logoutFromServer() throws IOException {
        this.out.write("LOGOUT\r\n".getBytes());
    }

    @AfterClass
    public void disconnectFromServer() throws IOException {
        try {
            this.out.close();
            this.in.close();
        } finally {
            this.socket.close();
        }
    }
}
