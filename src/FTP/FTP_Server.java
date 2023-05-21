package FTP;

import java.io.*;
import java.net.*;

public class FTP_Server {
    public static OutputStream _OutputStream;
    public static InputStream _InputStream;

    public static String strFtpServerFolderName = "ftp_server";

    public static boolean IsSendMessage(String  message, OutputStream _OutputStream) {
        byte[] bytes = null;
        try {
            bytes = message.getBytes("UTF-8");
            _OutputStream.write(bytes);
            _OutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String IsReceiveMessage(InputStream _InputStream){
        byte[] bytes = new byte[1024];
        try{
            int readByteCount = _InputStream.read(bytes);
            if(readByteCount < 0)
                return "[server]: Recieving data is False...";
            else
                return (new String(bytes, 0, readByteCount, "UTF-8"));
        }catch (IOException e){
            return "[server]: Error, Receive 001";
        }
    }

    public static void IsReceiveFile(InputStream _InputStream) throws IOException {
        // InputStream으로 데이터 단위로 입력을 받는 DataInputStream을 개통
        DataInputStream din = new DataInputStream(_InputStream);
        FileOutputStream _FileOutputStream = null;

        // Int형 데이터 전송 받음
        int data = din.readInt();

        // String형 데이터를 전송받아 filename(파일의 이름으로 쓰일)에 저장
        String filename = din.readUTF();
        String strFtpFileName = strFtpServerFolderName + "\\" + filename;
        File fFtpFile = new File(strFtpFileName);

        System.out.println("[server]: 크기 받기 성공, 파일 크기: " + data);

        if(fFtpFile.exists()){
            System.out.println("[server]: 이미 \"" + fFtpFile.toString() + "\" 파일이 존재합니다.");
            return;
        }

        // 생성한 파일을 클라이언트로부터 전송받아 완성시키는 FileOutputStream 개통
        _FileOutputStream = new FileOutputStream(fFtpFile);
        byte[] buffer = new byte[1024];

        // 전송받은 data의 횟수만큼 전송받아 FileOutputStream을 이용하여 File 완성
        for(int len; data>0; data--){
            len = _InputStream.read(buffer);
            _FileOutputStream.write(buffer, 0, len);
        }
        _FileOutputStream.close();
        _FileOutputStream.flush();
        System.out.println("[server]: \"" + filename + "\" 파일 전송 완료!!");
    }

    public static void IsSendFile(String message, OutputStream _OutputStream) throws IOException{
        DataOutputStream don = new DataOutputStream(_OutputStream);

        if(IsSendMessage(message, _OutputStream))
            System.out.println("");

        String strFtpFileName = strFtpServerFolderName + "\\" + message;
        File fFtpFile = new File(strFtpFileName);
        if(!fFtpFile.exists()){
            System.out.println("[server]: " + fFtpFile.toString() + " 파일이 존재하지 않습니다.");
            return;
        }

        byte[] buffer = new byte[1024];
        int len;
        int data = 0;

        FileInputStream _FileInputStream = new FileInputStream(fFtpFile);
        while((len = _FileInputStream.read(buffer)) > 0)
            data++;
        _FileInputStream.close();

        _FileInputStream = new FileInputStream(fFtpFile);
        don.writeInt(data);
        don.writeUTF(fFtpFile.getName());

        for(len = 0; data > 0; data--){
            len = _FileInputStream.read(buffer);
            _OutputStream.write(buffer, 0, len);
        }
        _OutputStream.flush();
        System.out.println("[server]: \"" + fFtpFile.getName() + "\" File Send Success !!");

    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        File fFtpServerFolder = new File(strFtpServerFolderName);
        if (!fFtpServerFolder.exists()){
            fFtpServerFolder.mkdir();
        }
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 5001));

            while (true){
                System.out.println("[server]: Waiting Connection");
                socket = serverSocket.accept();

                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("[server]: 연결 수락함 \"" + isa.getHostName() + "\"");

                byte[] bytes = null;
                String message = null;
                int readByteCount;

                while(true){
                    _OutputStream = socket.getOutputStream();
                    _InputStream = socket.getInputStream();

                    message = "\nHello" + isa.getHostName() + "... input the command ... \n";
                    message += "====== < MENU > =====\n";
                    message += " 1. dir (File List)\n";
                    message += " 2. mkdir(Folder Create)\n";
                    message += " 3. upload\n";
                    message += " 4. download\n";
                    message += " 5. delete\n";
                    message += " 6. quit\n";
                    message += "=====================\n";
                    message += "select number: \n";

                    if (IsSendMessage(message, _OutputStream))
                        System.out.println("[server]: MENU 데이터 보내기 성공");

                    message = IsReceiveMessage(_InputStream);

                    // 1. dir
                    if (message.equals("1")){
                        message = "";
                        File[] fList = fFtpServerFolder.listFiles();
                        for (int i = 0; i < fList.length; i++) {
                            File file = fList[i];
                            if(file.isFile()){
                                message += file.toString() + "\n";
                            }
                            else {

                            }
                        }
                        if(message == "")
                            message = "File does not exist!!\n";
                        if(IsSendMessage(message, _OutputStream))
                            System.out.println("[server]: DIR 데이터 보내기 성공");
                    }else if(message.equals("2")){
                        if(IsSendMessage(message, _OutputStream))
                            System.out.println("[server]: Folder Name 요청");

                        message = IsReceiveMessage(_InputStream);

                        System.out.println("[server]: 생성할 폴더명 받기 성공, 폴더명: " + message);
                        String strFtpFileName = strFtpServerFolderName + "\\" + message;
                        File fFtpFolder = new File(strFtpFileName);
                        if(!fFtpFolder.exists()){
                            fFtpFolder.mkdir();
                            System.out.println("[server]: 폴더 생성 성공");
                        }else {
                            System.out.println("[server]: 폴더 생성 실패, 이미 폴더가 존재합니다.");
                        }

                    }else if(message.equals("3")){
                        if(IsSendMessage(message, _OutputStream))
                            System.out.println("");

                        _InputStream = socket.getInputStream();
                        message = IsReceiveMessage(_InputStream);
                        System.out.println("[server]: 업로드할 파일명 받기 성공, 파송명: " + message);

                        IsReceiveFile(_InputStream);

                    }else if(message.equals("4")){
//                      // 업로드 부분을 참조하여 작성
                        // 서버와 클라이언트를 반대로
                        // Report
                        if(IsSendMessage(message, _OutputStream))
                            System.out.println("");

                        // 다운로드 해줄 파일명 받기
                        _InputStream = socket.getInputStream();
                        message = IsReceiveMessage(_InputStream);
                        System.out.println("[server]: 다운로드할 파일명 받기 성공, 파일명: " + message);

                        IsSendFile(message, _OutputStream);

                    }else if(message.equals("5")){
                        if(IsSendMessage(message, _OutputStream))
                            System.out.println("");
                        _InputStream = socket.getInputStream();
                        message = IsReceiveMessage(_InputStream);

                        String strFtpFileName = strFtpServerFolderName + "\\" + message;
                        File fFtpFile = new File(strFtpFileName);
                        if(fFtpFile.exists()){
                            fFtpFile.delete();
                            System.out.println("[server]: 삭제 성공, 파일명: " + message);
                        }else {
                            System.out.println("[server]: 삭제 실패, 파일명: " +message);
                        }
                    }else if(message.equals("6")){
                        bytes = message.getBytes("UTF-8");
                        _OutputStream.write(bytes);
                        _OutputStream.flush();
                        System.out.println("[server]: 접속종료 " + message);

                        break;
                    }else {
                        System.out.println(message);
                        break;
                    }
                }
                _InputStream.close();
                _OutputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!serverSocket.isClosed()){
            try {
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
