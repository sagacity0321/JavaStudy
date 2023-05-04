package after1;

import java.net.MalformedURLException;
import java.net.URL;

public class Example15 {
    public static void main(String[] args) throws MalformedURLException {
        URL _URL = new URL("https://www.wku.ac.kr/colleges/undergraduate.html#창의공과대학");
        System.out.println("getProtocol: " + _URL.getProtocol());
        System.out.println("getPort: " + _URL.getPort());
        System.out.println("getHost: " + _URL.getHost());
        System.out.println("getFile: " + _URL.getFile());
        System.out.println("getQuery: " + _URL.getQuery());
        System.out.println("getRef: " + _URL.getRef());
        System.out.println("toExternalForm: " + _URL.toExternalForm());
    }
}
