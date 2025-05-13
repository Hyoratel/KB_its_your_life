package ch15.sec06.exam01;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        //Stack 컬렉션 생성
        Stack<Coin> coinbox = new Stack<Coin>();

        //동전 넣기
        //LIFO
        coinbox.push(new Coin(100));
        coinbox.push(new Coin(50));
        coinbox.push(new Coin(500));
        coinbox.push(new Coin(10));

        //동전을 하나씩 꺼내기
        //pop : 꺼내기 / push : 넣기 / peek : 맨위에 꺼 보기
        while(!coinbox.isEmpty()){
            Coin coin = coinbox.pop();
            System.out.println("꺼내온 동전 : " +coin.getValue() + "원");
        }
    }
}
