package Course1;

public class Hello { // Define Class; Public==To allow access
    public static int sum(int n, int m){
        return n+m;
    }
    public static void main(String[] args){ // main()==JavaProgramStartingPoint
        int i = 20; // LocalVariable; ';'==end
        int s;
        char a;

        s = sum(i, 10);
        a = '?';
        System.out.println(a);
        System.out.println("Hello");
        System.out.println(s);
    }
}
