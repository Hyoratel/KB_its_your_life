package ch18.sec03.exam01;

import ch07.exam.Input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try //(InputStream is = new FileInputStream("c:/Temp/test1.db");)
        {
            //데이터 출발지를 test1.db로 하는 입력 스트림 생성
            InputStream is = new FileInputStream("c:/Temp/test1.db");

            while (true) {//무한루프
                int data = is.read(); //1바이트씩 읽기
                if (data == -1) break; //파일 끝에 도달했을 경우
                System.out.println(data);
            } //try
            is.close(); //입력 스트림을 닫고 사용 메모리 해제
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } //catch

//        try {
//            InputStream is = new FileInputStream("c:/Temp/test1.db");
//            int data;
//            while((data = is.read()) != -1) {
//                System.out.println(data);
//            }
//            is.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }//main
}
