package Course1;

class Rectt{
    private int width;
    private int height;
    public Rectt(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        Rectt p = (Rectt)obj;
        if (width*height == p.width*p.height)
            return true;
        else
            return false;
    }
}

public class EqualsEx {
    public static void main(String[] args) {
        Rectt a = new Rectt(2,3);
        Rectt b = new Rectt(3,2);
        Rectt c = new Rectt(3,4);
        if(a.equals(b))
            System.out.print("a is equal to b");
        if(a.equals(c))
            System.out.print("a is equal to c");
        if(b.equals(c))
            System.out.print("b is equal to c");
    }
}
