package after1;

import java.io.File;
import java.io.FileOutputStream;
public class Example03 {
    public static void main(String[] args) {
        String str = "안녕!! 원광대학교 고급자바프로그래밍";
        try{
            File _File = new File("example.txt");
            if(!_File.exists()){
                _File.createNewFile();
            }
            FileOutputStream _FileOutputStream = new FileOutputStream(_File);

            byte[] b = str.getBytes();
            _FileOutputStream.write(b);
            _FileOutputStream.close();
            System.out.println("파일 쓰기 성공");
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
