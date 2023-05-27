package ChatEx;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread{
    private DataOutputStream _DataOutputStream;
    String name;
    public Sender(Socket _Socket, String name){
        this.name = name;
        try{
            _DataOutputStream = new DataOutputStream(_Socket.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Scanner _Scanner = new Scanner(System.in);
        while (_DataOutputStream != null) {
            try {
                _DataOutputStream.writeUTF(name + " >>> " + _Scanner.nextLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        _Scanner.close();
    }
}
