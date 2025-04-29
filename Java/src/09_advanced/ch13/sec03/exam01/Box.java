package ch13.sec03.exam01;

public class Box <T>{
    //필드
    private T t;
    //Getter 메서드
    public T get() {
        return t;
    }
    //Setter 메서드
    public void set(T t) {
        this.t = t;
    }
}
