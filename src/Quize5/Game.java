package Quize5;

import java.util.Random;
import java.util.Scanner;

class Bear extends GameObject{
    Scanner key = new Scanner(System.in);
    String direction = new String();
    private void inform(){
        System.out.println("There is no movement");
    }

    public Bear(int startX, int startY, int distance){
        super(startX, startY, distance);

    }

    @Override
    public void move(){
        while(true) {
            System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
            direction = key.next();
            switch (direction) {
                case "a":
                    if(this.x == 0) {
                        inform();
                        continue;
                    }
                    this.x -= this.distance;
                    break;
                case "d":
                    if(this.y == 0) {
                        inform();
                        continue;
                    }
                    this.y -= this.distance;
                    break;
                case "s":
                    if(this.y == 10){
                        inform();
                        continue;
                    }
                    this.y += this.distance;
                    break;
                case "f":
                    if (this.x == 20) {
                        inform();
                        continue;
                    }
                    this.x += this.distance;
                    break;
                default:
                    System.out.println("잘못입력하셨습니다.");
                    continue;
            }break;
        }

    }
    public char getShape(){
        return 'B';
    }

}

class Fish extends GameObject{
    public Fish(int startX, int startY, int distance){
        super(startX, startY, distance);
    }

    @Override
    public void move(){
        Random random = new Random();
        int decision = random.nextInt(5);
        int move;

        if(decision > 2){
            while(true) {
                move = random.nextInt(4);
                switch (move) {
                    case 0:
                        if(this.x == 0) continue;
                        this.x -= this.distance;
                        break;
                    case 1:
                        if(this.y == 0) continue;
                        this.y -= this.distance;
                        break;
                    case 2:
                        if(this.y == 10) continue;
                        this.y += this.distance;
                        break;
                    case 3:
                        if (this.x == 20) continue;
                        this.x += this.distance;
                        break;
                    default:
                        System.out.println("잘못입력하셨습니다.");
                        continue;
                }break;
            }
        }
    }

    public char getShape(){
        return '@';
    }
}

class Map{
    public char shape[][] = new char[10][20];
    public void Map(){}
    public void showMap(int bx, int by, int fx, int fy, char b, char f){
        for(int i = 0; i < 10;i++){
            for(int j = 0; j < 20; j++) {
                if(i == by && j == bx){
                    System.out.print(shape[i][j] = b);
                } else if (i == fy && j == fx) {
                    System.out.print(shape[i][j] = f);
                }
                else {
                    System.out.print(shape[i][j] = '-');
                }
            }
            System.out.println();
        }
    }
}

public class Game {


    public static void main(String[] args){
        Map show = new Map();

        Random random = new Random();
        int f_x = random.nextInt(20);
        int f_y = random.nextInt(10);

        Bear bear = new Bear(0, 0, 1);
        Fish fish = new Fish(f_x, f_y, 1);

        int bx, by, fx, fy;
        char bb = bear.getShape(), ff = fish.getShape();


        System.out.println("** Bear의 Fish 먹기 게임을 시작합니다. **");
        boolean a = bear.collide(fish);

        while(true){
            bx = bear.getX();
            by = bear.getY();
            fx = fish.getX();
            fy = fish.getY();
            show.showMap(bx, by, fx, fy, bb, ff);
            if(bear.collide(fish)){

                break;
            }
            System.out.println(bx +" "+ by + " "+ fx +" "+ fy);
            bear.move();
            fish.move();
        }System.out.println("Bear Wins!");

    }
}
