package Thread;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Example33 {
    Socket cSocket;
    PrintWriter out;

    public Example33(String Name){
        System.out.println("#[ " + Name + " ] Client is Connecting on Server.");
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            cSocket = new Socket(localAddress, 10001);
            out = new PrintWriter(cSocket.getOutputStream(), true);
            System.out.println("#[ " + Name + " ] Client is Connected!");
            out.println(Name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String [] arrName = {"mice", "cow", "horse", "chicken", "bird"};
        for(int i = 0; i < 5; i++){
            final int index = i;
            new Thread(() -> {
                new Example33(arrName[index]);
            }).start();
            Thread.sleep(1000);
        }
    }
}
