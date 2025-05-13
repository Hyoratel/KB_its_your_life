package ch13.sec03.exam01;

public class GenericExample {
    // 제네릭 메서드: 전달받은 값을 Box에 담아 반환해주는 유틸리티 메서드
    public static <T> Box<T> boxing(T t) {
        // Box 객체 생성 (T 타입에 맞는 박스 생성)
        Box<T> box = new Box<T>();
        // 전달받은 값을 박스에 저장
        box.set(t);
        // 박스 반환
        return box;
    }

    public static void main(String[] args) {
        Box<Integer> box1 = boxing(100);
        int intValue = box1.get();
        System.out.println(intValue);
        Box<String> box2 = boxing("홍길동");
        String strValue = box2.get();
        System.out.println(strValue);
    }

}
