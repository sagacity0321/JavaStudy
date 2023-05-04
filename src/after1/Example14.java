package after1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Example14 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] _InetAddress_Arr = InetAddress.getAllByName("www.naver.com");

        for(InetAddress i: _InetAddress_Arr){
            System.out.println(i.getHostAddress());
        }
    }
}

// 원래는 try-catch 써야 함.
// 큰 문제가 생기지 않으므로 try-catch를 사용하지 않았음
