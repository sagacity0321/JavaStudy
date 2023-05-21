package Thread;

// 코드의 간결성
public class Example25 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("===== Thread start =====");
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        }).start();
        Thread.sleep(500);
        System.out.println("===== Thread end ======");
    }
}
