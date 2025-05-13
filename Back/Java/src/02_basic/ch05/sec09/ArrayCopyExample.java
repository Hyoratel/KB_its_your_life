package ch05.sec09;

public class ArrayCopyExample {
    public static void main(String[] args) {
        String[] oldStrArray={"java","array","copy"};
//        5개 배열 생성
        String[] newStrArray=new String[5];
//        배열 복사
        System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
//        배열 항목 출력
        for(int i=0 ; i<newStrArray.length; i++){
            System.out.println(newStrArray[i]+",");
        }

    }
    }

