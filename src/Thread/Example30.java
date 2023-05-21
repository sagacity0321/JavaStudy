package Thread;

import java.util.Random;

class CarThread extends Thread{
    private String who;
    private SharedCar car;
    private String where;

    public CarThread(String who, SharedCar car, String where){
        this.who = who;
        this.car = car;
        this.where = where;
    }

    public void run(){
        car.drive(who, where);
    }
}

class SharedCar{
    public synchronized void drive(String name, String where){
        System.out.println(name + " 님이 차에 탔습니다.");
        Random r = new Random();
        for (int i = 0; i < r.nextInt(3); i++) {
            System.out.println(name + "님이 자동차를 운전합니다.");

        }
        System.out.println(name + "님이 " + where + "에 도착했습니다.");
    }
}
public class Example30 {
    public static void main(String[] args) {
        SharedCar car = new SharedCar();
        new CarThread("뺀지리", car, "서울").start();
        new CarThread("문둥이", car, "부산").start();
        new CarThread("깽깽이", car, "광주").start();
    }
}
