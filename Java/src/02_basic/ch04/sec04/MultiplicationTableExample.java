package ch04.sec04;

//구구단 가로버전(표처럼 바꾸려면 print 사용 하면 가능)
public class MultiplicationTableExample {
    public static void main(String[] args) {
//        1. 단 제목 한 줄에 출력
        for (int k = 2; k <= 9; k++) {
            System.out.print("***" + k + "단***");}
            System.out.println(" "); //제목 출력 후 줄바꿈

//        2. 구구단 반복
            for (int i = 1; i <= 9; i++) {
                for(int m =2; m<=9; m++){
                System.out.print(m + "*" + i + "=" + (i * m) + "\t");
                }
                System.out.println(" "); //한 줄 끝나면 줄 바꿈
                }
            }

        }

