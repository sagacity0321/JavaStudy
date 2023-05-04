package after1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example12 {
    public static void main(String[] args) throws IOException {
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.println("loopbackAddress: " + loopbackAddress. toString());

        InetAddress _InetAddress = InetAddress.getLocalHost();
        System.out.println("getLocalHost: " + _InetAddress.toString());
        System.out.println("hostAddress:: " + _InetAddress.getHostAddress());
        System.out.println("hostName: " + _InetAddress.getHostName());
        System.out.println("canonicalHost " + _InetAddress.getCanonicalHostName());
        System.out.println("isSiteLocalAddress: " + _InetAddress.isSiteLocalAddress());
        System.out.println("isLinkLocalAddress: " + _InetAddress.isLinkLocalAddress());
        System.out.println("isReachable: " + _InetAddress.isReachable(10));

        byte[] byteArr = _InetAddress.getAddress();
        for(byte b: byteArr){
            System.out.println("byte: " + (b & 0xff));
        }
        InetAddress[] arrInetAddress = InetAddress.getAllByName("localhost");
        for(InetAddress i: arrInetAddress){
            System.out.println("inetArr: " + i);
        }


    }
}
