package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NsLookup {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getByName(args[0]);
            System.out.print(ia.getHostName());
            System.out.println(": " + ia.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Unknown " + args[0]);
        }
    }
}
