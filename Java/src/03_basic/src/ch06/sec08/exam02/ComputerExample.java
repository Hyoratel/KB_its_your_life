package src.sec08.exam02;

//가변길이 매개변수 예제
public class ComputerExample {
    public static void main(String[] args) {
        Computer myCom = new Computer(); //Computer 객체 생성

//        sum 메소드 호출시 3개만큼
        int result1 = myCom.sum(1, 2, 3);
        System.out.println("result1: " + result1);

//        sum 메소드 호출시 5개만큼
        int result2 = myCom.sum(1, 2, 3, 4, 5);
        System.out.println("result2: " + result2);

//        sum 메소드 호출시 배열 제공
        int[] values = { 1, 2, 3, 4, 5 };
        int result3 = myCom.sum(values);
        System.out.println("result3: " + result3);

//        sum 메소드 호출시 배열 제공 결과를 result4 변수에 대입
        int result4 = myCom.sum(new int[] { 1, 2, 3, 4, 5 });
        System.out.println("result4: " + result4);
    }
}
