package ppt8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {
    public static void main(String[] args) {
        byte b[] = new byte[6]; // 빈 byte file

        try{
            FileInputStream fin = new FileInputStream("/Users/dpwl/Documents/2023Programs/JavaProgramming/ex1/src/ppt8/test.out");
            int n = 0, c;
            while((c = fin.read()) != -1){
                b[n] = (byte) c;
                n++;
            }
            System.out.println("test.out에서 읽은 배열을 출력합니다.");
            for(int i = 0; i<b.length; i++){
                System.out.print(b[i] + "");
            }
            System.out.println();
            fin.close();
        }
        catch(IOException e){
            System.out.println("test.out에서 읽지 못했습니다. 경로 명을 체크해보세요.");
        }
    }
}
