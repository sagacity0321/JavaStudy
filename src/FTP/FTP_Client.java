package FTP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FTP_Client {
    static Socket socket = null;
    static InputStream _InputStream = null;
    static OutputStream _OutputStream = null;
    static final String strFtpClientFolderName = "ftp_client";

    private static boolean IsSendMessage(String message, OutputStream _OutputStream){
        byte[] bytes = null;
        try{
            bytes = message.getBytes("UTF-8");
            _OutputStream.write(bytes);
            _OutputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
    private static String IsRecevieMessage(InputStream _InputStream){
        byte[] bytes = new byte[1024];
        try {
            int readByteConunt = _InputStream.read(bytes);
            if (readByteConunt < 0) {
                return "[Client] 데이터 받기 실패...]";
            }
            else {
                return (new String(bytes, 0, readByteConunt, "UTF-8"));
            }
        }catch (IOException e){
            return "[Error: Receive 001]";
        }
    }

    public static void IsReceiveFile(String filename) throws IOException {
        DataInputStream din = new DataInputStream(_InputStream);
        FileOutputStream _FileOutputStream = null;


        String strFtpFileName = strFtpClientFolderName + "/" + filename;
        File fFtpFile = new File(strFtpFileName);

        int data = din.readInt();

        System.out.println("[Client]: 크기 받기 성공, 파일 크기: " + data);
        if(fFtpFile.exists()){
            System.out.println("[Client]: 이미 \"" + fFtpFile.toString() + "\" 파일이 존재합니다.");
            return;
        }

        _InputStream = socket.getInputStream();

        // 생성한 파일을 클라이언트로부터 전송받아 완성시키는 FileOutputStream 개통
        _FileOutputStream = new FileOutputStream(fFtpFile);
        byte[] buffer = new byte[1024];

        // 전송받은 data의 횟수만큼 전송받아 FileOutputStream을 이용하여 File 완성
        for(int len; data>0; data--){
            len = _InputStream.read(buffer);
            _FileOutputStream.write(buffer, 0, len);
        }
        _OutputStream.flush();
        _FileOutputStream.close();
        _FileOutputStream.flush();

        System.out.println("[Client]: \"" + filename + "\" 파일 전송 완료!!");
    }

    private static void IsSendFile(File file) throws IOException {
        OutputStream _OutputStream = socket.getOutputStream();
        String message = file.toString();

        if(IsSendMessage(message, _OutputStream))
            System.out.println("");

        String strFtpFileName = strFtpClientFolderName + "/" + message;
        File fFtpFile = new File(strFtpFileName);
        if(!fFtpFile.exists()){
            System.out.println("[Client]: " + fFtpFile.toString() + " 파일이 존재하지 않습니다.");
            return;
        }
        _OutputStream = socket.getOutputStream();

        DataOutputStream dout = new DataOutputStream(_OutputStream);
        byte[] buffer = new byte[1024];
        int len;
        int data = 0;

        FileInputStream _FileInputStream = new FileInputStream(fFtpFile);
        while((len = _FileInputStream.read(buffer)) > 0)
            data++;
        _FileInputStream.close();

        _FileInputStream = new FileInputStream(fFtpFile);
        dout.writeInt(data);
        dout.writeUTF(fFtpFile.getName());

        for(len = 0; data > 0; data--){
            len = _FileInputStream.read(buffer);
            _OutputStream.write(buffer, 0, len);
        }

        _OutputStream.flush();
        _FileInputStream.close();
        System.out.println("[Client]: \"" + fFtpFile.getName() + "\" File Send Success !!");

    }

    public static void main(String[] args) {
        File fFtpClientFolder = new File(strFtpClientFolderName);
        if(!fFtpClientFolder.exists())
            fFtpClientFolder.mkdir();

        try{
            socket = new Socket();
            System.out.println("[Client: Server에 연결 요청]");
            socket.connect(new InetSocketAddress("localhost", 5002));
            System.out.println("[Client: Server에 연결 성공]");

            boolean isExit = false;
            while (true){
                if(isExit == true)
                    break;
                byte[] bytes = null;
                String message = null;

                _OutputStream = socket.getOutputStream();
                _InputStream = socket.getInputStream();

                message = IsRecevieMessage(_InputStream);
                System.out.print(message);

                Scanner _Scanner = new Scanner(System.in);
                message = _Scanner.next();
                if(IsSendMessage(message, _OutputStream))
                    System.out.println("");

                if(message.equals("1")){
                    System.out.println("====== File List ======");
                    message = IsRecevieMessage(_InputStream);
                    System.out.print(message);
                    System.out.println("=======================");

                }else if(message.equals("2")){
                    IsRecevieMessage(_InputStream);
                    System.out.print("[Client]: 생성할 폴더명을 입력해 주세요:");
                    _Scanner = new Scanner(System.in);
                    message = _Scanner.next();

                    if(IsSendMessage(message, _OutputStream))
                        System.out.println("[Client]: Folder Name Send Success !!");
                    Thread.sleep(500);

                }else if (message.equals("3")){
                    // 쓰레기 데이터 비우기
                    IsRecevieMessage(_InputStream);
                    System.out.print("[Client]: 업로드할 파일명을 입력해 주세요: ");
                    _Scanner = new Scanner(System.in);

                    // 전송할 파일들을 불러들일 스트링 변수 선언
                    String strSendFiles = _Scanner.nextLine();

                    // 서버에 업로드할 파일들을 공백 기준으로 잘라서 스트링 배열에 넣기
                    String[] strSendFileList = strSendFiles.split(" ");
                    // 업로드할 파일의 개수가 1개 이하 -> 단일 처리

                    // report
                    // Thread 없이 순서대로
                    int fileCount = strSendFileList.length;
                    message = Integer.toString(fileCount);
                    if(!IsSendMessage(message, _OutputStream))
                        System.out.println("There is " + fileCount + " files.");

                    for (int i = 0; i < strSendFileList.length; i++) {
                        String fileName = strSendFileList[i];
                        IsSendFile(new File(fileName));
                        Thread.sleep(500);
                    }

                    Thread.sleep(500);

                }else if(message.equals("4")){
                    // report

                    IsRecevieMessage(_InputStream);
                    System.out.print("[Client]: 다운로드할 파일명을 입력해 주세요: ");
                    _Scanner = new Scanner(System.in);

                    String strReceiveFiles = _Scanner.nextLine();
                    String[] strReceiveFileList = strReceiveFiles.split(" ");

                    int fileCount = strReceiveFileList.length;
                    message = Integer.toString(fileCount);
                    if(!IsSendMessage(message, _OutputStream))
                        System.out.println("There is " + fileCount + " files.");

                    for (int i = 0; i < strReceiveFileList.length; i++) {
                        String fileName = strReceiveFileList[i];
                        IsReceiveFile(fileName);
                        Thread.sleep(500);
                    }

                    Thread.sleep(500);


                }else if(message.equals("5")){
                    IsRecevieMessage(_InputStream);
                    System.out.print(_InputStream);

                    _Scanner = new Scanner(System.in);
                    message = _Scanner.next();

                    if(IsSendMessage(message, _OutputStream))
                        System.out.println("[Client]: Delete File Name Send Success !!");
                    Thread.sleep(100);


                }else if (message.equals("6")){
                    System.out.println("\n[Client: 접속 종료]");
                    isExit = true;
                    break;
                }
            }
            _OutputStream.close();
            _InputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        if (!socket.isClosed()){
            try{
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
