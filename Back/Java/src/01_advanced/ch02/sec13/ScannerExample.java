package ch02.sec13;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.println("x 값 입력: ");
        String strX = scanner.nextLine(); //nextLine() : 한 줄 전체 입력받기(String)
        int x = Integer.parseInt(strX);


        System.out.println("y 값 입력: ");
        String strY = scanner.nextLine();
        int y = Integer.parseInt(strY);

        int result = x + y;
        System.out.println("x+y: " + result);
        System.out.println();

//        형변환 없이 사용
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("x 값 입력: ");
//        int x = scanner.nextInt();  // 바로 정수로 입력 받음
//
//        System.out.print("y 값 입력: ");
//        int y = scanner.nextInt();  // 역시 바로 정수
//
//        int result = x + y;
//        System.out.println("x + y = " + result);

        while(true){
            System.out.println("입력문자열:");
            String data = scanner.nextLine();
            if(data.equals("q")){
                break;
            }
            System.out.println("출력문자열:"+data);
            System.out.println();

        }
        System.out.println("종료");
    }
}
