package ch05.sec05;

import org.w3c.dom.ls.LSOutput;

public class IndexOfContainsExample {
    public static void main(String[] args) {
        String subject="자바 프로그래밍";
        int location = subject.indexOf("프로그래밍");
        System.out.println(location);

        location=subject.indexOf("자바");
//        subject함수는 못찾으면 -1값을 반환하기 떄문
        if(location !=-1){
            System.out.println("자바와 관련된 책이군요.");
        } else System.out.println("자바와 관련 없는 책이군요.");
    }


}
