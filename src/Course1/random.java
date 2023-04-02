package Course1;

import java.util.Random;
import java.util.Scanner;

public class random {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random r = new Random();

        int i, j = 0;
        int row, col;

        System.out.println("2차원 배열의 행의 수를 입력하세요.");
        row = input.nextInt();

        int arr[][];
        arr = new int[row][];
        int sum[];
        sum = new int[row];
        int avg[];
        avg = new int[row];
        int len[];
        len = new int[row];

        for(i = 0; i < arr.length; i++) {
            System.out.println("2차원 배열의 " + i + "번째 행의 열 개수를 입력하세요");
            col = input.nextInt();
            arr[i] = new int[col];
            sum[i] = 0;
            len[i] = col;
        }

        for(i = 0; i < arr.length; i++){
            for(j=0; j < arr[i].length; j++) {
                arr[i][j] = r.nextInt(50);
                sum[i] = sum[i] + arr[i][j];
            }
            avg[i] = sum[i]/len[i];
        }

        for(i = 0; i < arr.length; i++) {
            System.out.println(i + "행: 평균값= " + avg[i] + ", 원소개수= " + len[i]);
        }
    }
}
