package AprilCourse;

import java.util.*;

class Student{
    int id;
    String tel;
    public Student(int id, String tel){
        this.id = id; this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public String getTel() {
        return tel;
    }
}
public class HashMapStudentEx {
    public static void main(String[] args) {
        // 학생 이름과 Student객체를 쌍으로 저장하는 HashMap 컬렉션 생성
        HashMap<String, Student> map = new HashMap<String, Student>();

        // 3 Student
        map.put("황기태", new Student(1, "010-111-1111"));
        map.put("이재문", new Student(2, "010-111-2222"));
        map.put("김남윤", new Student(3, "010-111-3333"));

        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("검색할 이름?");
            String name = scan.nextLine(); // 사용자로부터 이름 입력
            if (name.equals("exit")){
                break; // while 문을 벗어나 프로그램 종료
            }
            Student student = map.get(name); // 이름에 해당하는 Student 객체 검색
            if(student == null){
                System.out.println(name + "은 없는 사람입니다.");
            }
            else{
                System.out.println("id: "+ student.getId() + ", 전화: " + student.getTel());
            }
            scan.close();
        }
    }
}
