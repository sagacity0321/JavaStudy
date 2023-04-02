package Course1;
import java.util.Random;
import java.util.Scanner;

public class RCPGame {
    public static void main(String[] args){
        Random r = new Random();
        int rNum = r.nextInt(2 );

        Scanner scan = new Scanner(System.in);
        String tool = new String();

        while(true) {
            System.out.println("가위바위보 게임을 시작할게요!(가위, 바위, 보 중 하나를 입력하세요.)");
            tool = scan.next();

            if(tool == "0"){
                break;
            }

            if ( args[rNum] == tool ) {
                System.out.println("비겼습니다! 너: " + tool + ", 나: " + args[rNum]);
            } else if( args[rNum] == "가위" || tool == "보") {
                System.out.println("내가 이겼네요! 너: " + tool + ", 나: " + args[rNum]);
            } else if (args[rNum] == "바위" || tool == "가위") {
                System.out.println("내가 이겼네요! 너: " + tool + ", 나: " + args[rNum]);
            } else if (args[rNum] == "보" || tool == "바위") {
                System.out.println("내가 이겼네요! 너: " + tool + ", 나: " + args[rNum]);
            } else {
                System.out.println("네가 이겼네요! 너: " + tool + ", 나: " + args[rNum]);
            }
        }
    }
}
