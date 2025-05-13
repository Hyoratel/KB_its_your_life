package ch15.sec05.exam03;

import java.util.TreeSet;

public class ComparableExample {
    public static void main(String[] args) {
        //TreeSet 컬렉션 생성
        TreeSet<Person>treeSet = new TreeSet<>();

        //데이터(객체) 저장
        treeSet.add(new Person("홍길동", 35));
        treeSet.add(new Person("감자바", 25));
        treeSet.add(new Person("박지원", 31));

        //객체 하나씩 가져오기
        for(Person person : treeSet) {
            System.out.println(person.name + "," + person.age);
        }
        //Person메서드에 compareTo()에 age 정렬 내용이 있으므로 age정렬
    }
}
