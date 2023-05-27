package ChatEx;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket _Socket = new Socket("localhost", 7777);
            System.out.println("# 서버 준비 완료...");
            System.out.println("# 소켓: " + _Socket);

            System.out.println("Enter your name(ID) >>>");
            Scanner _Scanner = new Scanner(System.in);
            String name = _Scanner.next();

            DataOutputStream _DataOutputStream = new DataOutputStream(_Socket.getOutputStream());
            _DataOutputStream.writeUTF(name);
            _DataOutputStream.flush();

            Sender _Sender = new Sender(_Socket, name);
            Receiver _Receiver = new Receiver(_Socket);

            _Sender.start();
            _Receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
