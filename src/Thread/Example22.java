class Thread_A extends Thread { // Thread Class로 부터 상속
    public void run(){ // Thread Class의 run() 메소드 오버라이딩 > 수행 문장 기술(Thread가 실행할 코드)
        for(int i = 0; i < 5; i++){
            System.out.println(i);
        }
    }
}
public class Example22 {
    public static void main(String[] args) {
        Thread_A thread1 = new Thread_A();
        System.out.println("====== Thread start ======");
        thread1.start();

        System.out.println("===== Thread End =====");
    }
}

