package after1;
import java.io.*;

public class Example10 {
    public static boolean IsFileCopy(String InFilePath, String OutFilePath){
        File InFile = new File(InFilePath);
        File OutFile = new File(OutFilePath);

        try{
            if(!InFile.exists()){
                InFile.createNewFile();
            }
            FileInputStream _FileInputStream = new FileInputStream(InFile);
            FileOutputStream _FileOutputStream = new FileOutputStream(OutFile);
            int i = 0;

            while((i = _FileInputStream.read()) != -1){
                _FileOutputStream.write((char) i);
            }
            _FileInputStream.close();
            _FileOutputStream.close();

        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String InFilePath = "example05.txt";
        String OutFilePath = "example05-복사본11.txt";

        if(IsFileCopy(InFilePath, OutFilePath)){
            System.out.println("파일 복사 성공!!");
        }
        else{
            System.out.println("파일 복사 실패!!");
        }
    }
}
// 과제