package ch18.sec03.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        try //(OutputStream os = new FileOutputStream("c:/Temp/test2.db");)
        {
            OutputStream os = new FileOutputStream("c:/Temp/test2.db");

            byte[] array = {10, 20, 30};

            os.write(array);

            os.flush();
            os.close();

        } catch (IOException e) { // 파일을 읽거나 쓸 때 문제가 발생할 경우
            e.printStackTrace(); // 문제가 발생했을때 어디서 예외가 발생했는지 콘솔에 출력

        }
    }
}
