package ch08.sec11.exam01;

public class Car {
    //필드
    Tire tire1 = new HankookTire();
    Tire tire2 = new HankookTire();

    //메서드
    void run(){
        //인터페이스에 선언된 추상 메서드 호출(구현 객체에 roll() 메서드 실행)
        tire1.roll();
        tire2.roll();
    }
}
