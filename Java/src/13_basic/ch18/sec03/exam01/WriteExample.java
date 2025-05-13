package ch18.sec03.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {

//        try (OutputStream os = new FileOutputStream("c:/Temp/test1.db")) { //최신 문법
         try{
             OutputStream os = new FileOutputStream("c:/Temp/test1.db");

            byte a = 10;
            byte b = 20;
            byte c = 30;

            //1바이트씩 출력
            os. write(a);
            os. write(b);
            os. write(c);

            os.flush(); //내부 버퍼 잔류 바이트 출력하고 버퍼를 비움.
            os.close(); //최신문법 미사용시 close 반드시!!
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("파일 생성 완료!!");

    }
}
