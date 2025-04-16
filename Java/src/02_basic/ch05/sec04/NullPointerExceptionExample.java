package ch05.sec04;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        int[] intArray = null;
        intArray[0] = 10; // intArray 초기화된 상태이므로 0번째 값에 10을 저장할 수 없음.
        String str = null;
        System.out.println("총 문자 수: " + str.length() ); // 위와 동일한 이유로 str의 길이를 확인할 수 없음.
    }
}
