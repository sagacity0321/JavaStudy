package Thread;
class Runnable_A implements Runnable{
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(i);
        }
    }
}
public class Example23 {
    public static void main(String[] args) throws InterruptedException {
        Thread _Thread = new Thread(new Runnable_A());
        System.out.println("===== Thread start =====");
        _Thread.start();
        _Thread.join();
        System.out.println("===== Thread end ======");
    }

}
