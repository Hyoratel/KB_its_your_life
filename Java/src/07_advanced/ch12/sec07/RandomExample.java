package ch12.sec07;

import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RandomExample {
    public static void main(String[] args) {
        //로또 예측 번호
        Set<Integer> lotto = new HashSet<>(); //중복 제거
        while (lotto.size() < 6) {
            int number = (int) (Math.random() * 45) + 1;// 1~45범위
            lotto.add(number);
        }
        System.out.println("로또 예측 번호: " + lotto);

        //로또 당첨 번호
        Set<Integer> lotto2 = new HashSet<>();
        while (lotto2.size() < 6) {
            int number = (int) (Math.random() * 45) + 1;// 1~45범위
            lotto2.add(number);
        }
        System.out.println("로또 당첨 번호: " + lotto2);
        //ArraySort 활용
        //배열활용시 데이터양이 많아질 경우 배열이 약간 더 빠를수 있음.
        //메서드가 제한적(배열은 고정형)

        //Set -> 배열변환
        Integer[] predicted = lotto.toArray(new Integer[0]);
        Integer[] actual = lotto2.toArray(new Integer[0]);

        //배열정렬
        Arrays.sort(predicted);
        Arrays.sort(actual);

        //출력
        System.out.println("예측 번호(정렬): " + Arrays.toString(predicted));
        System.out.println("당첨 번호(정렬): " + Arrays.toString(actual));

        //비교
        if(Arrays.equals(predicted, actual)) {
            System.out.println("당첨");
        } else {
            System.out.println("유감");
        }

//        //List 활용
          //가독성,재사용성이 높음.
//        //Set -> List 변환
//        List<Integer> predicted = new ArrayList<>(lotto);
//        List<Integer> actual = new ArrayList<>(lotto2);
//
//        //정렬
//        Collections.sort(predicted);
//        Collections.sort(actual);
//
//        //출력
//        System.out.println("에측번호(정렬): " + predicted);
//        System.out.println("당첨번호(정렬): " + actual);
//
//        //비교
//        if (predicted.equals(actual)) {
//            System.out.println("1등 당첨");
//        } else {
//            System.out.println("아쉽지만 꽝입니다.");
//        }
    }
}
