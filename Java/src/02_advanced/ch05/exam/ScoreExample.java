package ch05.exam;

import java.util.Scanner;

//조건
//학생 수 입력 -> 학생들 점수 입력 ->입력된 점수 리스트 출력 -> 최고 점수와 평균 분석

public class ScoreExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = null; // 학생들의 점수를 저장할 배열 (배열의 크기를 모르므로 null 로 초기화)
        int studentNum = 0; // 학생 수 저장
        boolean run = true; // 프로그램 실행 제어용

        while(run) {
            System.out.println("--------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("--------------------------------------------------");
            System.out.print("선택> ");

            int selcetNo = scanner.nextInt();

            //if문 사용
            if (selcetNo == 1) {
                System.out.println("학생수> ");
                studentNum = scanner.nextInt();
                scores = new int[studentNum]; // 배열 초기화
            } else if (selcetNo == 2) {
                for (int i = 0; i < studentNum; i++) {
                    System.out.println("scores[" + i + "]> ");
                    scores[i] = scanner.nextInt(); //i점수는 입력값을 받는다.
                }
            } else if (selcetNo == 3) {
                for (int i = 0; i < studentNum; i++) {
                    System.out.println("scores[" + i + "] = " + scores[i]);
                }
            } else if (selcetNo == 4) {
                int max = 0;
                int sum = 0;
                for (int i = 0; i < studentNum; i++) {
                    if (scores[i] > max) {
                        max = scores[i];
                    }
                    sum += scores[i];
                }
                double avg = sum / studentNum;

                System.out.println("최고점수: " + max);
                System.out.println("평균점수: " + avg);
            } else if (selcetNo == 5) {
                System.out.println("프로그램 종료");
                run = false;
            } else System.out.println("1~5번 중 입력하세요.");

        } scanner.close();

        //switch문 사용
//        switch (selectNo) {
//            case 1:
//                System.out.print("학생수> ");
//                studentNum = scanner.nextInt();
//                scores = new int[studentNum]; // 빈 배열 생성
//                break;
//
//            case 2:
//                if (scores == null) {
//                    System.out.println("먼저 학생 수를 입력하세요.");
//                    break;
//                }
//                for (int i = 0; i < studentNum; i++) {
//                    System.out.print("scores[" + i + "]> ");
//                    scores[i] = scanner.nextInt();
//                }
//                break;
//
//            case 3:
//                if (scores == null) {
//                    System.out.println("먼저 학생 수와 점수를 입력하세요.");
//                    break;
//                }
//                for (int i = 0; i < studentNum; i++) {
//                    System.out.println("scores[" + i + "] = " + scores[i]);
//                }
//                break;
//
//            case 4:
//                if (scores == null) {
//                    System.out.println("먼저 점수를 입력하세요.");
//                    break;
//                }
//                int max = 0;
//                int sum = 0;
//                for (int i = 0; i < studentNum; i++) {
//                    if (scores[i] > max) {
//                        max = scores[i];
//                    }
//                    sum += scores[i];
//                }
//                double avg = (double) sum / studentNum;
//                System.out.println("최고점수: " + max);
//                System.out.println("평균점수: " + avg);
//                break;
//
//            case 5:
//                System.out.println("프로그램 종료");
//                run = false;
//                break;
//
//            default:
//                System.out.println("1~5번 중 입력하세요.");
//        }
    }
}
