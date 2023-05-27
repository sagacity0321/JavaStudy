package ChatEx;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatServer {
    public static void main(String[] args) {
        System.out.println("# 서버 준비 완료...");
        try {
            ServerSocket _ServerSocket = new ServerSocket(7777);
            System.out.println("# 연결 준비중...");
            Socket _Socket = _ServerSocket.accept();

            System.out.println("# 서버의 소켓: " + _Socket);

            Sender _Sender = new Sender(_Socket, "Server");
            Receiver _Receiver = new Receiver(_Socket);

            _Sender.start();
            _Receiver.start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
