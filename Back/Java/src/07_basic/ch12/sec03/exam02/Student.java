package ch12.sec03.exam02;

//학생 정보를 저장할 Student 클래스 정의
public class Student {
    //학번과 이름은 private으로 캡슐화
    private int no;
    private String name;

    //생성자 : 학번과 이름 초기화
    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }
    //학번,이름 getter
    public int getNo() { return no; }
    public String getName() { return name; }

    //해시코드 오버라이딩
    @Override
    public int hashCode() {
        //학번과 이름의 해시코드를 합산해서 반환
        int hashCode = no + name.hashCode();
        return hashCode;
    }

    //equals 메서드 오버라이딩
    @Override
    public boolean equals(Object obj) {
        // obj가 Student 타입인지 확인하고 형 반환
        if(obj instanceof Student target) {
            //학번과 이름이 모두 같으면 true
            if(no == target.getNo() && name.equals(target.getName())) {
                return true;
            }
        }
        return false;
    }
}