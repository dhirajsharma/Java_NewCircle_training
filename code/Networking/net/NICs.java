
package net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NICs {
    public static void main(String[] args) throws Exception {
        for (Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces(); nis
                .hasMoreElements();) {
            NetworkInterface ni = nis.nextElement();
            System.out.println(ni.getDisplayName());
            for (Enumeration<InetAddress> ias = ni.getInetAddresses(); ias.hasMoreElements();) {
                InetAddress ia = ias.nextElement();
                System.out.println("\t" + ia.getHostAddress());
            }
        }
    }
}
