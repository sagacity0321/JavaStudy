package after1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Example18 {
    public static void main(String[] args) {
        ServerSocket _ServerSocket = null;
        Socket _Socket = null;
        try{
            _ServerSocket = new ServerSocket(8080);
            System.out.println("[Server실행] Client 연결대기중...");
            _Socket = _ServerSocket.accept();
            System.out.println("Client가 접속 했습니다.");
            System.out.println("Client ip: " + _ServerSocket.getInetAddress());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                _Socket.close();
                _ServerSocket.close();
                System.out.println("연결종료");
            }catch (IOException e){
                System.out.println("소켓통신에러");
            }
        }
    }
}
