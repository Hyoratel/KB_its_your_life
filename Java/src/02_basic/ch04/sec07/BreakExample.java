package ch04.sec07;

public class BreakExample {
//    throws Exception 예외가 생겨도 프로그램이 멈추지 않게함.
    public static void main(String[] args) throws Exception{
        while (true) { //무한루프 시작 true가 조건이므로 반복 지속
            int num =(int)(Math.random()*6)+1;
            System.out.println(num);
            if (num == 6) break;
        }
        System.out.println("프로그램 종료");
    }
}
