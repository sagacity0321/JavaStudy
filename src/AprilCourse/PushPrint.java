package AprilCourse;
// 1. Stack<E> 를 활용하여 문장이 입력되면 Stack에 Push하고
// "All Print" 라는 문자열이 들어오면 Stack의 내용을 전부 출력
// "Print 3"이라는 문자열이 들어오면 3번째 Stack 내용 출력

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;


public class PushPrint {
    public static void main(String[] args) {
        int i = 0;
        Scanner input = new Scanner(System.in);
        String text = new String();

        Stack<String> stack = new Stack<>();


        while(true){
            // input text
            text = input.nextLine();
            String[] textArray = text.split(" ");

            // if "All Print" > print all
            if(Objects.equals(text, "All Print")){
                for(i = 0; i < stack.size(); i++){
                    System.out.print(stack.get(i));
                    if(i < stack.size() -1){
                        System.out.print(", ");
                    }
                    else{
                        System.out.println();
                    }
                }
                continue;
            }

            // else if "Print 3" > print 3rd
            else if(Objects.equals(text, "Print 3")){
                System.out.println(stack.get(2));
                continue;
            }

            // else if ";" > break
            else if(Objects.equals(text, ";")){
                break;
            }
            // else > push to stack
            else{
                stack.clear();
                for(i = 0; i < textArray.length; i++){
                    stack.add(textArray[i]);
                }
                continue;
            }
        }

    }

}
