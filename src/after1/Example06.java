package after1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Example06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File _File = new File("example06.txt");
        boolean quit = true;
        try{
            if(!_File.exists()){
                _File.createNewFile();
            }
            FileWriter _FileWriter = new FileWriter(_File);

            while (quit) {
                System.out.print("학번: ");
                String Num = input.next();

                System.out.print("이름: ");
                String Name = input.next();

                _FileWriter.write("학번: " + Name + "\n");
                _FileWriter.write("이름: " + Num + "\n");

                System.out.print("종료하시려면 \"N\" 입력: ");
                input = new Scanner(System.in);
                String str = input.nextLine();

                if(str.toUpperCase().equals("N")){
                    quit = false;
                }
            }
            _FileWriter.close();
            System.out.println("파일 쓰기 성공");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
