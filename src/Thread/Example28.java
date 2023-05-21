package Thread;

class Thread_B extends Thread{
    public Thread_B(String name){
        setName(name);
    }
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.print(getName() + " -> ");
            try{
                sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }
}
public class Example28 {
    public static void main(String[] args) {
        Thread_B t1 = new Thread_B("느긋한");
        t1.setPriority(Thread.MIN_PRIORITY);
        Thread_B t2 = new Thread_B("급한");
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
