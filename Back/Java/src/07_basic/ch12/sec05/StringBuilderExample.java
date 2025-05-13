package ch12.sec05;

public class StringBuilderExample {
    public static void main(String[] args) {
        String data = new StringBuilder()
                .append("DEF") //문자열 끝에 추가
                .insert(0, "ABC") // 지정 위치 추가
                .delete(3, 4) // 문자열 일부 삭제
                .toString(); // 완성된 문자열 리턴
        System.out.println(data);
    }
}

//실행결과 ABCEF
