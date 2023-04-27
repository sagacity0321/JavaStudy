package ppt8;

import java.io.*;
import java.util.*;

public class FileWriterEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FileWriter fout = null;
        int c;

        try{
            fout = new FileWriter("/Users/dpwl/Documents/2023Programs/JavaProgramming/ex1/src/ppt8/text.txt");
            while(true){
                String line = scan.nextLine();
                if(line.length() ==0){
                    break;
                }
                fout.write(line, 0, line.length());
                fout.write("\r\n", 0, 2);
            }
            fout.close();
        }
        catch (IOException e){
            System.out.println("입출력 오류");
        }
        scan.close();
    }
}

// 콘솔에 text.txt 입력할 것들 입력하고 엔터 두번