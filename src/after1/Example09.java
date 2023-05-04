package after1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Example09 {
    public static void main(String[] args) {
        try{
            File _File = new File("example.txt");
            if(!_File.exists()){
                _File.createNewFile();
            }
            FileReader _FileReader = new FileReader(_File);
            BufferedReader _BufferedReader = new BufferedReader(_FileReader);
            String str;
            while ((str = _BufferedReader.readLine()) != null){
                System.out.println(str);
            }
            _FileReader.close();
            System.out.println("파일 읽기 성공");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
