package ch04.sec01;

//문제 잘 읽어볼 것. "1부터 100 이하"
public class ForSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 3 == 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
