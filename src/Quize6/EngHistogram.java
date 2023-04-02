package Quize6;

import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EngHistogram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int alphabet = 0;
        int[] hist = new int[26];
        String word = "";
        int index = 0;

        System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");

        while(true){
            String text = input.next();
            if(Objects.equals(text, ";")){
                break;
            }
            StringTokenizer words = new StringTokenizer(text, " ,.?![]{}()/");
            while(words.hasMoreTokens()){
                word = words.nextToken();
                index = (int)word.charAt(0);
                if(index <= 90){
                    hist[index - 65] += 1;
                }
                else{
                    hist[index - 97] += 1;
                }
            }
        }

        for(int n : hist){
            System.out.println((char)(alphabet+65)+"-".repeat(n));
            alphabet++;
        }

    }
}
