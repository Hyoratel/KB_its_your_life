package src.sec07.exam05;

public class Car {
    // 필드 선언
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    Car(){
        this.model = "기본모델";
        this.color = "은색";
        this.maxSpeed = 200;
    }

    Car(String model) {
        //20라인 생성자 호출
        this(model, "은색", 250);
    }

    Car(String model, String color) {
        //20라인 생성자 호출
        this(model, color, 250);
    }

//20라인 생성자 (오버로딩시 매개변수 개수나 타입이 같아야 한다)
    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}