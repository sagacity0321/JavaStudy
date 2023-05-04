package after1;
import java.io.File;
import java.io.FileOutputStream;
public class Example04 {
    public static void main(String[] args) {
        File _File = new File("Example04.txt");


        try{
            if(!_File.exists()){
                _File.createNewFile();
            }
            FileOutputStream _FileOutPutStream = new FileOutputStream(_File);
            for(int k = 1; k < 10; k += 3 ){
                for(int i = 1; i < 10 ; i++){
                    String doublings = "";
                    for(int j  = k; j < k+3; j++){
                        doublings += j + " X " + i + " = " + j*i + "\t";
                    }
                    doublings += "\n";
                    byte[] b = doublings.getBytes();
                    _FileOutPutStream.write(b);
                }
            }


            _FileOutPutStream.close();
            System.out.println("파일 쓰기 성공");
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
