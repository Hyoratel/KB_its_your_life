package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {

        int result = data.length(); //data가 null일 경우 NullPointerException 발생
        System.out.println("문자 수: " + result);

    }
    public static void main(String[] args) {

        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null); // 매개값으로 null 대입
        System.out.println("[프로그램 종료]");

    }
}
// data가 null일 경우 NullPointerException 발생
// 결과 : Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
//	at ch11.sec02.exam01.ExceptionHandlingExample1.printLength(ExceptionHandlingExample1.java:6)
//	at ch11.sec02.exam01.ExceptionHandlingExample1.main(ExceptionHandlingExample1.java:14)
