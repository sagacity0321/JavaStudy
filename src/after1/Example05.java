package after1;

import java.io.File;
import java.io.FileWriter;

public class Example05 {
    public static void main(String[] args) {
        try{
            File _File = new File("example05.txt");
            if(!_File.exists()){
                _File.createNewFile();
            }
            FileWriter _FileWriter = new FileWriter(_File);

            _FileWriter.write("Hello!!\n");
            _FileWriter.write("Java Programming");
            _FileWriter.close();
            System.out.println("파일 쓰기 성공");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
