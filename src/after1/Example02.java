package after1;

import java.io.File;
public class Example02 {
    public static void main(String[] args) {
        File _File = new File("src/after1/Example02.java");
        if(_File.exists()){
            System.out.println("파일의 이름: " + _File.getName());
            System.out.println("파일의 경로: " + _File.getAbsolutePath());
            System.out.println("파일 쓰기가 가능한가? -> " + _File.canWrite());
            System.out.println("파일 읽기가 가능한가? -> " + _File.canRead());
            System.out.println("파일의 크기: " + _File.length());
        }
        else{
            System.out.println("존재하는 파일이 아닙니다.");
        }
    }
}
