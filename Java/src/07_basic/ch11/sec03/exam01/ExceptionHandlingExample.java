package ch11.sec03.exam01;

//배열의 인덱스가 초과되었을 경우 발생하는 ArrayIndexOutOfBoundsException
//배열의 인덱스가 숫자가 아닐 때 발생하는 NumberFormatException
public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"}; //문자열 배열 선언
        for(int i=0; i<=array.length; i++) { // i<=array.length에서 ArrayIndexOutOfBoundsException 유발
            try {
                int value = Integer.parseInt(array[i]); // 문자열 정수 변환
                System.out.println("array[" + i + "]: " + value);
            } catch (ArrayIndexOutOfBoundsException e) { //배열 인덱스가 범위를 벗어났을때 발생
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
            } catch (NumberFormatException e) { //문자열을 정수로 바꿀 수 없을 때 발생
                System.out.println("숫자로 변환할 수 없음: " + e.getMessage());
            }

        }

    }
}
