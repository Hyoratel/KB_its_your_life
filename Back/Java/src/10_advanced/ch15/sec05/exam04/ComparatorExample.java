package ch15.sec05.exam04;

import java.util.TreeSet;

public class ComparatorExample {
    public static void main(String[] args) {
        //객체 생성시 비교기준을 구현한 클래스를 매개변수를 넣어줌. -> 자동정렬
        TreeSet<Fruit> treeSet = new TreeSet<>(new FruitComparator());

        //객체 저장
        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));

        //객체 하나씩 가져오기
        for(Fruit fruit : treeSet){
            System.out.println(fruit.name+":"+fruit.price);
        }
    }
}
