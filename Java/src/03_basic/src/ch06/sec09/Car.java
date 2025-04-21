package src.ch06.sec09;

public class Car {
    //필드 선언
    String model;
    int speed;

    Car(String model){
        this.model = model; //매개변수를 필드에 대입
    }

    void setSpeed(int speed){
        this.speed = speed; //매개변수를 필드에 대입
    }

    void run(){
        System.out.println(this.model + "가 달립니다.(시속:" + this.speed +"km/h)");
    }

}




