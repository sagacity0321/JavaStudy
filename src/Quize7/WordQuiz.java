package Quize7;
import java.util.*;

class Word{
    String eng,kor;
    HashMap<String, String> word = new HashMap<String, String>();
    public Word(String eng, String kor){
        this.eng = eng;
        this.kor = kor;
        word.put(eng, kor);
    }

    public String getEng(){
        return eng;
    }
    public String getKor(){
        return kor;
    }
    public String getAns(String wEng){
        return word.get(wEng);
    }

}

public class WordQuiz {
    public static void main(String[] args) {
        Vector<Word> v = new Vector<Word>();
        v.add(new Word("love", "사랑"));
        v.add(new Word("animal", "동물"));
        v.add(new Word("painting","그림"));
        v.add(new Word("bear", "곰"));
        v.add(new Word("eye", "눈"));
        v.add(new Word("picture", "사진"));
        v.add(new Word("society", "사회"));
        v.add(new Word("human", "인간"));
        v.add(new Word("tear", "눈물"));
        v.add(new Word("word", "세계"));
        v.add(new Word("bank","은행"));
        v.add(new Word("doll", "인형"));
        v.add(new Word("huge", "거대한"));

        Scanner input = new Scanner(System.in);
        int text = 0;

        int count = v.size();

        Random ran = new Random();
        int ranN[] = new int[4];
        int ranW[] = new int[4];
        int i, j;

        System.out.println(v.get(2));
        String engW, korW;
        String wk[] = new String[4];

        System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 "+count+"개의 단어가 들어 있습니다.");

        while(true){
            for(i = 0; i < 4; i++){
                ranN[i] = ran.nextInt(count);
                for(j = 0; j<i; j++){
                    if(ranN[i] == ranN[j]){
                        i--;
                    }
                }
            }
            for(i = 0; i < 4; i++){
                ranW[i] = ran.nextInt(4);
                for(j = 0; j < i; j++){
                    if(ranW[i] == ranW[j]){
                        i--;
                    }
                }
            }

            engW = v.get(ranN[0]).getEng();
            korW = v.get(ranN[0]).getKor();

            System.out.println(engW + "?");

            for(i = 0; i<4; i++){
                wk[i] = v.get(ranN[ranW[i]]).getKor();
                System.out.print("(" + (i+1) + ")" +wk[i] + " ");
            }
            System.out.print(":>");
            text = input.nextInt();
            if(text == -1){
                System.out.println("\"명품영어\"를 종료합니다...");
                break;
            }
            else if(wk[text-1] == korW){
                System.out.println("Excellent!!");
            }
            else {
                System.out.println("No.");
            }

        }
    }
}
