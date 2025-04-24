package ch11.sec05;

public class ThrowsExample1 {
    public static void main(String[] args) {

        try {
            //1. findClass() 메서드 호출
            findClass();

        } catch(ClassNotFoundException e ) {
            //4. 예외발생을 이 블록에서 처리
            System.out.println("예외 처리: " + e.toString());

        }

    }
    //ClassNotFoundExceptiondl 이 발생할 수 있고, 직접 처리하지 않고 호출자에게 예외를 넘김.
    public static void findClass() throws ClassNotFoundException {
        //2. 이 메서드 내부에서 Class.forName 실행
        Class.forName("java.lang.String2"); // 3. 클래스가 존재하지 않음(예외발생)

    }
}
