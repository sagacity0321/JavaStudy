package Course1;

import java.util.Random;
import java.util.Scanner;
public class FindOutCard {
    public static void main(String[] args){
        Random r = new Random();
        Scanner in = new Scanner(System.in);

        int rnum = r.nextInt(100);

        System.out.println("랜덤 숫자가 생성되었습니다: 100 이하의 값\n숫자를 맞춰보세요!");
        int num = 0;

        while(true){
            System.out.println("숫자를 입력해 주세요.");
            num = in.nextInt();
            if(rnum > num){
                System.out.println("땡! 틀렸네요. 그것보다 더 큰 수예요!");
            } else if (rnum < num) {
                System.out.println("땡! 틀렸네요. 그것보다 더 작은 수예요!");
            } else{
                System.out.println("축하합니다!");
                break;
            }
        }

    }
}
