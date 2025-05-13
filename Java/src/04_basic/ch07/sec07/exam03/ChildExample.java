package ch07.sec07.exam03;

public class ChildExample {
    public static void main(String[] args) {
        //객체 생성 및 자동 타입 변환
        Parent parent = new Child();

        //Parent 타입으로 필드와 메소드 사용
        parent.field1 = "data1";
        parent.method1(); // Parent-method1()
        parent.method2(); // Parent-method2()

        //Child에만 있는 field2는 parent 타입으로 작성하여서 컴파일 오류 발생.
//        parent.field2 = "data2";
//        parent.method3();

        Child child = (Child) parent;
        child.field2 = "data2";
        child.method3();
    }

}
