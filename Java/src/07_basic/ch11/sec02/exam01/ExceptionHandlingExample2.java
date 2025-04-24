package ch11.sec02.exam01;

public class ExceptionHandlingExample2 {
    public static void printLength(String data) {
        try {
            int result = data.length(); //data가 null일때 NullPinterException 발생
            System.out.println("문자수: " + result);
        } catch(NullPointerException e) {
            //예외 정보를 얻는 3가지 방법
            //System.out.println(e.getMessage()); // 예외가 발생한 이유만 리턴
            //System.out.println(e.toString()); // 예외의 종류도 리턴
            e.printStackTrace(); // 예외가 어디서 발생했는지 추적한 내용까지도 출력
        } finally {
            System.out.println("[마무리 실행]\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");
    }
}

//결과값
//[프로그램 시작]
//
//문자수: 10
//        [마무리 실행]
//
//        [마무리 실행]
//
//        [프로그램 종료]
//java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
//at ch11.sec02.exam01.ExceptionHandlingExample2.printLength(ExceptionHandlingExample2.java:6)
//at ch11.sec02.exam01.ExceptionHandlingExample2.main(ExceptionHandlingExample2.java:21)