package Thread;

class Thread_A extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("잘가. ");
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

}
public class Example27 {
    public static void main(String[] args) throws InterruptedException {
        Thread_A thread1 = new Thread_A();
        thread1.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("안녕. ");
            Thread.sleep(500);
        }
    }
}
