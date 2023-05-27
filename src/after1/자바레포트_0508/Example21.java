package after1;

import java.io.*;
import java.net.Socket;

public class Example21 {
    public static void main(String[] args) {
        Socket _Socket = null;
        InputStream _InputStream = null;
        DataInputStream _DataInputStream = null;
        try{
            _Socket = new Socket("127.0.0.1", 8080);
            System.out.println("Server와 접속 되었습니다.");

            _InputStream = _Socket.getInputStream();
            _DataInputStream = new DataInputStream(_InputStream);

            while(true){
                String str = _DataInputStream.readUTF();
                if(str.equals("e")){
                    break;
                }
                System.out.println("서버에서 전송된 문자: "+ str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                _DataInputStream.close();
                _InputStream.close();
                _Socket.close();
                System.out.println("연결종료");
            }catch (IOException e){
                System.out.println("소켓통신에러");
            }
        }
    }
}
