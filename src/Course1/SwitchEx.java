package Course1;
import java.util.Scanner;
public class SwitchEx {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.println("가위바위보 게임을 시작하겠습니다.(입력예시: '가위 보')");

        String winC = "철수가 이겼습니다!";
        String winY = "영희가 이겼습니다!";
        String same = "비겼습니다.";

        String chul = scanner.next();
        String yung = scanner.next();

//        switch (chulSu){
//            case "가위":
//                switch(yungHi){
//                    case "가위":
//                        System.out.println(same);
//                        break;
//                    case "바위":
//                        System.out.println(winY);
//                        break;
//                    case "보":
//                        System.out.println(winC);
//                        break;
//                }
//            case "바위":
//                switch(yungHi) {
//                    case "가위":
//                        System.out.println(winC);
//                        break;
//                    case "바위":
//                        System.out.println(same);
//                        break;
//                    case "보":
//                        System.out.println(winY);
//                        break;
//                }
//            default:
//                switch(yungHi) {
//                    case "가위":
//                        System.out.println(winY);
//                        break;
//                    case "바위":
//                        System.out.println(winC);
//                        break;
//                    case "보":
//                        System.out.println(same);
//                        break;
//                }
//
//        }
    }
}
