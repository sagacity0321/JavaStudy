package after1;

import java.io.File;
import java.io.FileInputStream;

public class Example07 {
    public static void main(String[] args) {
        try{
            File _File = new File("example05.txt");
            if(!_File.exists()){
                _File.createNewFile();
            }
            FileInputStream _FileInputStream = new FileInputStream(_File);
            int i = 0;

            while((i = _FileInputStream.read()) != -1){ // 뒤에서부터 읽는걸로 계산해야 안깨짐
                System.out.print((char) i);
            }
            _FileInputStream.close();
            System.out.println("\n파일 읽기 성공");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
