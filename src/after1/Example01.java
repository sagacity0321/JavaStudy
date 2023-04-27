package after1;

import java.io.IOException;
import java.io.File;
public class Example01 {
    public static void main(String[] args) {
        File _File = new File("example01.text");
        try{
            boolean success = _File.createNewFile();
            if(success){
                System.out.println("파일 생성 성공");
            }
            else {
                System.out.println("파일 생성 실패");
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
