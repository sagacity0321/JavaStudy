package ppt8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadHangulSuccess {
    public static void main(String[] args) {
        InputStreamReader in = null;
        FileInputStream fin = null;

        try{
            fin = new FileInputStream("/Users/dpwl/Documents/2023Programs/JavaProgramming/ex1/src/ppt8/hangul.txt");
            in = new InputStreamReader(fin, "UTF-8");
            int c;

            System.out.println("인코딩 문자 집합은" + in.getEncoding());
            while((c = in.read()) != -1){
                System.out.print((char)c);
            }
            in.close();
            fin.close();
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }
    }
}

// 한글 깨짐: IDE 자체에서 바꿔야 함
// MS949 > UTF-8: 여기서 바꾸니까 되네