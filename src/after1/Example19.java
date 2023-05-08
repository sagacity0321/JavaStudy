package after1;

import java.io.IOException;
import java.net.Socket;

public class Example19 {
    public static void main(String[] args) {
        Socket _Socket = null;
        try{
            _Socket = new Socket("127.0.0.1", 8080);
            System.out.println("Server와 접속되었습니다.");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                _Socket.close();
                System.out.println("연결종료");
            }catch(IOException e){
                System.out.println("소켓통신에러");
            }
        }
    }
}
