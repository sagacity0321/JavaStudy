package ChatEx;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ChatMultiServer {
    static HashMap<String, DataOutputStream> clientMap;

    public static void main(String[] args) {
        ExecutorService _Executorservice = Executors.newFixedThreadPool(5);

        clientMap = new HashMap<String , DataOutputStream>();
        Collections.synchronizedMap(clientMap);

        System.out.println("# 서버 준비 완료...");
        try(ServerSocket server = new ServerSocket(7777)){
            System.out.println("# 연결 대기중...");
            while(true){
                Socket _Socket = server.accept();

                ServerReceiver _ServerReceiver = new ServerReceiver(_Socket);
                _Executorservice.submit(_ServerReceiver);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static class ServerReceiver extends Thread{
            Socket _Socket;
            DataOutputStream _DataOutputStream;
            DataInputStream _DataInputStream;
        public ServerReceiver(Socket _Socket){
            this._Socket = _Socket;
            try {
                _DataOutputStream = new DataOutputStream(_Socket.getOutputStream());
                _DataInputStream = new DataInputStream(_Socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            String name = "";

            try{
                System.out.println("# 소켓: "+ _Socket);
                name = _DataInputStream.readUTF();
                System.out.println(name);

                clientMap.put(name, _DataOutputStream);

                while(_DataInputStream != null){
                    String msg;
                    msg = _DataInputStream.readUTF();

                    IsAllSendMessage(msg);
                }

            }catch (IOException e){
                e.printStackTrace();
            }

        }

        private boolean IsAllSendMessage(String msg) {
            Iterator it = clientMap.keySet().iterator();

            while(it.hasNext()){
                try{
                    DataOutputStream it_out = (DataOutputStream)  clientMap.get(it.next());
                    it_out.writeUTF(msg);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            return true;
        }
    }
}
