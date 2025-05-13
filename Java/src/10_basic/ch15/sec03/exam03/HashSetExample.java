package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//HashSet 사용법 + 반복문 순회 방식 2가지
public class HashSetExample {
    public static void main(String[] args) {
        //HashSet 컬렉션 생성(HashSet은 중복 제거 및 순서 보장 X)
        //set : 인터페이스 / Hashset : 구현체
        Set<String>set = new HashSet<>();

        //객체 추가
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        //객체를 하나씩 가져와서 처리
        //Iterator 패턴으로 순회하며 각 요소 출력
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
        System.out.println();
        //향상된 for 문으로 순회하며 각 요소 출력
        for(String element : set) {
            System.out.println(element);
        }
        //HashSet은 입력순서를 유지하지 않기때문에 순서가 바뀔수도 있다!
    }
}
