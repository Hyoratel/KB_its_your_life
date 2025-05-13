package ch05.sec05;

public class SubStringExample {
    public static void main(String[] args) {
        String ssn = "880815-1234567";
//        substring(int beginIndex) beginIndex 미만
        String firstNum = ssn.substring(0,6);
        System.out.println(firstNum);

//        substring(beginIndex) beginInde 부터 끝까지
        String secondNum = ssn.substring(7);
        System.out.println(secondNum);
    }

}
