package ch15.sec05.exam04;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample2 {
    public static void main(String[] args) {
        //Comparator 익명 구현 객체로 생성
        TreeSet<Fruit> treeSet = new TreeSet<>(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit p1, Fruit p2) {
                return Integer.compare(p1.price, p2.price);
            }
        });

        //객체 저장
        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));

        //객체 하나씩 가져오기
        for(Fruit fruit : treeSet) System.out.println(fruit.name+":"+fruit.price);

    }
}
