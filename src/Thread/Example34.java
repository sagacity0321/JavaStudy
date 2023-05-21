package Thread;

import java.net.*;
import java.util.Scanner;

class PortScanThread extends Thread{
    String ip = null;
    int port = 0;
    int timeout = 1000;

    public PortScanThread(String ip, int port, int timeout){
        this.ip = ip;
        this.port = port;
        this.timeout = timeout * this.timeout;
    }

    @Override
    public void run() {
        Socket _Socket = null;

        SocketAddress addr = new InetSocketAddress(this.ip, this.port);
        try {
            _Socket = new Socket();
            _Socket.connect(addr, this.timeout);

            System.out.println("open: " + this.port);
            _Socket.close();
        }catch (Exception e){

        }
    }
}
public class Example34 {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        int start = 1;
        int end = 0xffff;

        String port_range = null;
        String ip = null;

        System.out.print("Enter targer ip: ");
        ip = input.nextLine();

        System.out.print("Enter Port Range(ex: 1-100): ");
        port_range = input.nextLine();

        try{
            new Socket(ip, 80);
            String[] ports = port_range.split("-");

            if(!(ports[0].equals(""))){
                start = Integer.parseInt(ports[0]);
                end = Integer.parseInt(ports[1]);
            }
        }
        catch (UnknownHostException e){
            System.out.println("Wrong ip"); return;
        }catch (Exception e){
            System.out.println("Wrong Entering"); return;
        }

        PortScanThread _PortScanThread = null;

        for(; start <= end; start++){
            _PortScanThread = new PortScanThread(ip, start, 1);
            _PortScanThread.start();
        }

        Thread.sleep(10000);
        System.out.println("\nComplete Port Scan!");
    }
}
