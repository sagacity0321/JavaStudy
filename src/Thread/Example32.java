package Thread;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Example32 implements Runnable{
    private static Socket clientSocket;
    static PrintWriter out = null;

    public Example32(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public static void main(String[] args) {
        ExecutorService eService = Executors.newFixedThreadPool(5);
        System.out.println("#Start Server");
        try(ServerSocket sSocket = new ServerSocket(10001)){
            while(true){
                System.out.println("#Connecting...");
                clientSocket = sSocket.accept();
                Example32 tes = new Example32(clientSocket);
                eService.submit(tes);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("#Close Server");
        eService.shutdown();
    }

    @Override
    public void run() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream out = clientSocket.getOutputStream();
            String UserId = br.readLine();
            System.out.println("#[" + UserId + "] is Connected.");
            Thread.sleep(5000);
            out.close();
            System.out.println("#Client: " + UserId + " is Closed.");
        }catch (IOException | InterruptedException ex){
        }
    }
}
