package ppt13;

public class SynchronizedEx {
    public static void main(String[] args) {
        SharedBoard board = new SharedBoard();
        Thread th1 = new StudentThread("kitae", board);
        Thread th2 = new StudentThread("hyosoo", board);
        th1.start();
        th2.start();
    }
}

class SharedBoard{
    private int sum = 0;
    synchronized public void add(){
        int n = sum;
        Thread.yield(); // 현재 실행 중인 스레드 양보
        n += 10; // add 10
        sum = n; // added val record
        System.out.println(Thread.currentThread().getName() + " : " + sum);
    }
    public int getSum(){ return sum; }
}

class StudentThread extends Thread{
    private SharedBoard board; // 집계판의 주소
    public StudentThread(String name, SharedBoard board){
        super(name);
        this.board = board;
    }

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            board.add();
        }
    }
}