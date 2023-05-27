package after1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Example20 {
    public static void main(String[] args) {
        ServerSocket _ServerSocket = null;
        Socket _Socket = null;
        OutputStream _OutputStream = null;
        DataOutputStream _DataOutputStream = null;
        Scanner scanner = new Scanner(System.in);

        String str = "";
        try{
            _ServerSocket = new ServerSocket(8080);
            System.out.println("[Server 실행] Client 연결 대기중...");
            _Socket = _ServerSocket.accept();
            System.out.println("Client가 접속 했습니다.");
            System.out.println("Client ip: " + _Socket.getInetAddress());

            _OutputStream = _Socket.getOutputStream();
            _DataOutputStream = new DataOutputStream(_OutputStream);

            while (true) {
                System.out.println("전송할 데이터를 입력하세요(\"e\"를 입력하면 종료됩니다.)");
                if(str.equals("e")){
                    break;
                }
                str = scanner.nextLine();
                _DataOutputStream.writeUTF(str);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                _DataOutputStream.flush();
                _DataOutputStream.close();
                _OutputStream.close();
                _Socket.close();
                _ServerSocket.close();
                System.out.println("연결종료");
            } catch (IOException e) {
                System.out.println("소켓통신에러");
            }
        }
    }
}
