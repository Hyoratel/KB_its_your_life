package ch06.Bank;

public class InsufficientException extends Exception {
    //기본생성자
    public InsufficientException() {

    }
    //예외를 받는 생성자
    public InsufficientException(String message) {
        super(message);
    }
}
