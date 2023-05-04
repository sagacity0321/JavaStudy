package after1;

import java.io.IOException;
import java.net.InetAddress;

public class Example13 {
    public static void main(String[] args) throws IOException {
        InetAddress _InetAddress = InetAddress.getByName("www.google.com");
        System.out.println("inetAddr: " + _InetAddress.toString());
        System.out.println("host ip: " + _InetAddress.getHostAddress());
        System.out.println("host name: " + _InetAddress.getHostName());
        System.out.println("isReachable: " + _InetAddress.isReachable(1000));
        System.out.println();

        _InetAddress = InetAddress.getByName("www.wku.ac.kr");
        System.out.println("inetAddr: " + _InetAddress.toString());
        System.out.println("host ip: " + _InetAddress.getHostAddress());
        System.out.println("host name: " + _InetAddress.getHostName());
        System.out.println("isReachable: " + _InetAddress.isReachable(1000));
    }
}
