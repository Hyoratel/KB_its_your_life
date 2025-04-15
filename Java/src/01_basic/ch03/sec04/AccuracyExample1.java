package ch03.sec04;

//부동소수점 방식을 사용하는 실수타입에서 발생. 정확한 계산은 정수타입으로!
public class AccuracyExample1 {
    public static void main(String[] args) {
        int apple = 1;
        double pieceUnit = 0.1;
        int number = 7;
        double result = apple - number*pieceUnit;
        System.out.println("사과 1개에서 남은 양: " + result);
    }
}
