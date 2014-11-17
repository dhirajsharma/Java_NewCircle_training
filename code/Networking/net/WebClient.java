
package net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This program fetches the content referenced by the specified URL and writes
 * it to STDOUT.
 */
public class WebClient {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: WebClient <url>");
        } else {
            try {
                fetch(new URL(args[0]));
            } catch (MalformedURLException e) {
                System.err.println("Malformed URL: " + args[0]);
            } catch (IOException e) {
                System.err.println("Failed to fetch URL " + args[0] + ": " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void fetch(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        InputStream in = connection.getInputStream();
        try {
            byte[] buf = new byte[1024];
            int nread = 0;
            while ((nread = in.read(buf)) > 0) {
                System.out.write(buf, 0, nread);
            }
            System.out.flush();
        } finally {
            in.close();
        }
        connection.disconnect();
    }

}
