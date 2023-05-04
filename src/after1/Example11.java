package after1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Example11 {
    public static boolean IsFileCopy(String InFilePath, String OutFilePath){
        File InFile = new File(InFilePath);
        File OutFile = new File(OutFilePath);
        try {
            Files.copy(InFile.toPath(), OutFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String InFilePath = "example05.txt";
        String OutFilePath = "example05-복사본.txt";

        if(IsFileCopy(InFilePath, OutFilePath)){
            System.out.println("파일 복사 성공!!");
        }
        else{
            System.out.println("파일 복사 실패!!");
        }
    }
}
