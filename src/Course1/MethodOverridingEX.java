package Course1;

class Shape{ // Super class
    public Shape next;
    public Shape() {next = null;}

    public void draw(){
        System.out.println("Shape");
    }
}

class Line extends Shape{
    public void draw(){ // Method Overriding
        System.out.println("Line");
    }
}

class Rect extends Shape{
    public void draw(){ // Method Overriding
        System.out.println("Rect");
    }
}

class Circle extends Shape{
    public void draw(){  // Method Overriding
        System.out.println("Circle");
    }
}

public class MethodOverridingEX {
    static void paint(Shape p){
        p.draw(); // p가 가리키는 객체 내에 오버라이딩 된 call draw(). 동적 바인딩
    }

    public static void main(String[] args){
        Line line = new Line();

        paint(line);
        paint(new Shape());
        paint(new Line());
        paint(new Rect());
        paint(new Circle());
    }
}
