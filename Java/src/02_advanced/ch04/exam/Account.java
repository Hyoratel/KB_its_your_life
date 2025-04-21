package ch04.exam;

import java.util.Scanner;

public class Account {
    public static void main(String[] args) {
        boolean run = true; // 반복 실행 제어
        int balance = 0; // 계좌 잔액 저장 변수
        Scanner scan = new Scanner(System.in); // 객체 생성

        while (run) { // run이 true일경우 반복
            System.out.println("------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("------------------------------");
            System.out.println("선택>");

            //사용자로부터 메뉴 번호 입력받기(문자열 -> 정수 변환)
            int menuNum = Integer.parseInt(scan.nextLine());
//            String strNum = scan.nextLine(); // 메뉴 번호를 문자열로 입력받음

            switch (menuNum) {
                case 1:
                    System.out.println("예금액> ");
                    //입력받은 금액을 정수로 변환하여 잔액에 추가
                    balance += Integer.parseInt(scan.nextLine());
                    break;
                case 2:
                    System.out.println("출금액> ");
                    //입력받은 금액을 정수로 변환하여 잔액에서 차감
                    balance -= Integer.parseInt(scan.nextLine());
                    break;
                case 3:
                    System.out.println("잔고> ");
                    System.out.println(balance);
                    break;
                case 4:
                    run = false;
                    break;
                    // 1~4외 숫자 입력시 아무 처리 없음.
                    default:
                        System.out.println("1~4번호 중 골라주세요.");
                        break;
            }
            System.out.println();
        }
        System.out.println("프로그램 종료");

        scan.close(); // scanner 닫기
    }}
//}
        // 메뉴 처리: if-else if 사용
//            if (strNum.equals("1")) {
//                System.out.print("예금액> ");
//                int deposit = Integer.parseInt(scan.nextLine()); // 입력을 정수로 변환
//                balance += deposit; // 잔고에 예금액 추가
//
//            } else if (strNum.equals("2")) {
//                System.out.print("출금액> ");
//                int withdraw = Integer.parseInt(scan.nextLine()); // 입력을 정수로 변환
//                if (withdraw <= balance) {
//                balance -= withdraw; // 잔고에서 출금액 차감
//                } else {
//                        System.out.println("잔고가 부족합니다."); // 출금액이 잔고보다 많으면 경고
//                }
//                } else if (strNum.equals("3")) {
//                    System.out.println("잔고> " + balance); // 잔고 출력
//
//                } else if (strNum.equals("4")) {
//                    System.out.println("프로그램 종료");
//                run = false; // while문 종료
//
//                } else {
//                System.out.println("올바른 번호를 입력하세요."); // 잘못된 메뉴 번호 입력 시
//                }
//
//                    System.out.println(); // 줄바꿈
//        }
//
//                scan.close(); // Scanner 닫기.
//    }
//            }