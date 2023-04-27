// 예제 8-5

package ppt8;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {
    public static void main(String[] args) {
        byte b[] = {7, 51, 3, 4, -1, 24};

        try{
            FileOutputStream fout = new FileOutputStream("/Users/dpwl/Documents/2023Programs/JavaProgramming/ex1/src/ppt8/test.out");
            for(int i = 0; i < b.length; i++){
                fout.write(b[i]); // 배열 b의 바이너리를 그대로 기록
            }
            fout.close();
        }
        catch (IOException e){
            System.out.println("해당 경로에 저장할 수 없었습니다. 경로명을 확인해 주세요");
            return;
        }
        System.out.println("text.out을 저장하였습니다.");
    }
}

// 바이너리 파일이 되므로 메모장으로 볼 수 없다.