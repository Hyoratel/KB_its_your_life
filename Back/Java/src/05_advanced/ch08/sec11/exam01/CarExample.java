package ch08.sec11.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car(); //자동차 객체 생성
        myCar.run(); //run() 메소드 실행

        //타이어 객체 교체
        myCar.tire1 = new KumhoTire();
        myCar.tire2 = new KumhoTire();

        //run()메서드 실행
        myCar.run();


    }
}
