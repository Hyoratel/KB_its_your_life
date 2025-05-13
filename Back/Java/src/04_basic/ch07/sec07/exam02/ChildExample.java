package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        //자식 객체 생성
        Child child = new Child();
        //자동 타입 변환
        Parent parent = child;

        //메소드 호출
        parent.method1();
        //Child.method2가 오버라이딩되어 호출됨.
        parent.method2();

        //호출불가능 : Parent 부모 클래스에서 정의되지 않는 메서드, 자식만의 메서드는 사용할 수 없음.
//        parent.method3();
    }

}
