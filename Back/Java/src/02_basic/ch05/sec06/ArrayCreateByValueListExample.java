package ch05.sec06;

public class ArrayCreateByValueListExample {
    public static void main(String[] args) {
        int[] scores = new int[]{ 83, 90, 87 };

        // 메서드 호출
        printItem(scores);
    }

    // 메서드는 main 바깥에 선언해야 함
    public static void printItem(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "]:" + scores[i]);
        }
    }
}