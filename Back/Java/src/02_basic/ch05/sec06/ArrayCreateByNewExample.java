package ch05.sec06;

public class ArrayCreateByNewExample {
    public static void main(String[] args) {
//    배열 변수 선언과 배열 생성
        int[] arr1 = new int[3];
//        배열 항목의 초기값 출력
        for(int i = 0; i < arr1.length; i++){
            System.out.println("arr1[" + i + "]:" + arr1[i]);
        }
//        배열 변수 선언과 생성
        String[] arr2 = new String[3];
//        배열 항목의 초기값 출력
        for(int i = 0; i < arr2.length; i++){
            System.out.println("arr2[" + i + "]:" + arr2[i]);
        }

    }
}
