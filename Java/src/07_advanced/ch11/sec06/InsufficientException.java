package ch11.sec06;

public class InsufficientException extends Exception {
    //기본생성자
    public InsufficientException() {

    }
    //예외를 받는 생성자
    public InsufficientException(String message) {
        super(message);
    }
}
