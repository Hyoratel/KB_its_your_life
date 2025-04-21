package ch04.exam;

import java.util.Scanner;

public class Account {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        int number = 0;

        while (run) {
            System.out.println("------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("------------------------------");
            System.out.println("선택>");

            String strNum = scan.nextLine();

            if (strNum.equals("1")) {
                System.out.println("예금액>" + strNum);
            }


        }
    }
}
