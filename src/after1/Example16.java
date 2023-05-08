package after1;

import java.net.*;
import java.io.*;
public class Example16 {
    public static void main(String[] args) throws Exception {
        URL _URL = new URL("http://www.snujn.com/news/3233");
        URLConnection _URLConnection = _URL.openConnection();

        System.out.println("getContentType: " + _URLConnection.getContentType());
        System.out.println("===== 문서 내용 ======");
        InputStream _InputStream = _URLConnection.getInputStream();

        int nWord = 500;
        int c;
        while(((c = _InputStream.read()) != 1) && (--nWord > 0)){
            System.out.print((char) c);
        }
        _InputStream.close();
    }
}
