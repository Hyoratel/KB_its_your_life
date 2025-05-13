package ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList< >();
        list1.add("this is java");
        list1.add("i am a best developer");

        //문장 스트림을 단어 스트림으로 변환 후 출력
        //각 문장을 단어로 분리(split)한 뒤 flatMap으로 하나의 스트림으로 평탄화하여 출력
        list1.stream().
                flatMap(data->Arrays.stream(data.split(" "))) //공백기준으로 단어 분리 -> 스트림으로 변환
                .forEach(word-> System.out.println(word));
        System.out.println();

        //문자열 숫자 목록 스트림을 숫자 스트림으로 변환 후 출력
        List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
        //각 문자열을 쉼표로 분리한 뒤 숫자로 변환하여 하나의 IntStream.으로 평탄화하여 출력
        list2.stream()
                .flatMapToInt(data->{
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length]; //int 배열 생성
                    for(int i=0;i<strArr.length;i++){
                        intArr[i] = Integer.parseInt(strArr[i].trim()); //문자열 숫자를 정수로 변환(공백 제거)
                    }
                    return Arrays.stream(intArr); //int[] ->IntStream 반환
                }).forEach(number -> System.out.println(number));
    }
}
