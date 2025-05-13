package ch13.sec01;

public class GenericExample {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>(); // 동일타입 호출시 우변에 <> 생성자에는 타입 생략가능
        box1.content="안녕하세요.";
        String str = box1.content;
        System.out.println(str);

        Box<Integer> box2 = new Box<>(); // 동일타입 호출시 우변에 <> 생성자에는 타입 생략가능
        box2.content=100;
        int value = box2.content;
        System.out.println(value);
    }
}
