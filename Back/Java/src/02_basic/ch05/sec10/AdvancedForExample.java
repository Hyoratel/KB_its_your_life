package ch05.sec10;

//향상된 for문은 편하긴 하지만, 인덱스에대한 접근이 안되므로 값만 꺼내쓸때 유용
public class AdvancedForExample {
    public static void main(String[] args) {
        int[] scores = {95, 71, 84, 93, 87};
        int sum = 0;
        for (int score : scores) {
            sum = sum + score;
        }
        System.out.println("sum = " + sum);
//        배열 전체 평균 구하기
        double avg = (double) sum / scores.length; //length는 필드
        System.out.println("avg = " + avg);
    }
}
