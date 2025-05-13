package ch15.sec03.exam02;

import java.util.HashMap;
import java.util.Map;
//사용자 정의 클래스(Member)를 Hashset,HashMap 등에 넣을 때, "동일한 데이터"가 들어왔을 때 중복으로
//간주되게 하려면 반드시 equals() / hashcode()를 올바르게 재정의 해야함.
public class Member {
    Map<String, Integer> map = new HashMap<>();
    public String name; //이름
    public int age; //나이

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //hashCode() 재정의
    //같은 이름과 나이를 가진 객체는 동일한 해시값을 갖도록 정의

    @Override
    public int hashCode() {
        return name.hashCode() + age; //문자열 name의 해시코드 + 나이
    }

    //equals() 재정의
    //두 Member 객체가 "이름과 나이가 같으면" true 반환

    @Override
    public boolean equals(Object obj) {
        //obj가 Member 타입이면 비교 진행
        if(obj instanceof Member target) { //instanceof : 객체가 특정 클래스(또는 자식클래스)의 인스턴스 인지 확인하는 연산자
            //이름과 나이가 같으면 true
            return target.name.equals(name) && (target.age == age);
        } else {
            return false; //Member 타입이 아니면 false
        }
    }
}
