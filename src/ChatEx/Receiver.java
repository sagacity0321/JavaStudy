package ChatEx;

import java.io.DataInputStream;
import java.net.Socket;

public class Receiver extends Thread{
    private DataInputStream _DataInputStream;

    public Receiver(Socket _Socket){
        try{
            _DataInputStream = new DataInputStream(_Socket.getInputStream());
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public void run() {
        try{
            System.out.println(_DataInputStream.readUTF());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
