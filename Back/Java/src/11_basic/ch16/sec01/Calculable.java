package ch16.sec01;

import ch15.sec06.exam02.Message;

@FunctionalInterface
public interface Calculable {
    //추상 메소드
    void calculate(int x, int y);
}
