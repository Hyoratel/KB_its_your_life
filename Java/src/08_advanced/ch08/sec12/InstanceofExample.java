package ch08.sec12;

public class InstanceofExample {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Bus bus = new Bus();

        //ride() 메소드 호출 시 구현 객체를 매개값으로 전달
        ride(taxi);
        System.out.println();
        ride(bus);
    }
//    방법1
    public static void ride(Vehicle vehicle) {
        if(vehicle instanceof Bus){ //매개값이 Bus인 경우에만 강제 타입 변환해서 checkFare()메소드 호출
            Bus bus = (Bus) vehicle;
            bus.checkFare();
        }
//    방법2
//        if(vehicle instanceof Bus bus){bus.checkFare();}

        vehicle.run();
    }
}
