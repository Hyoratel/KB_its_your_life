package ch18.sec04.exam02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {
    public static void main(String[] args) {
        try {
        Reader reader = null;

        //문자씩 읽기
        reader = new FileReader("c:/Temp/test.txt");
        while(true) {
            int data = reader.read(); //문자를 읽음
            if(data == -1) break;
            System.out.print((char)data);
        }
        reader.close();
        System.out.println();

        //문자 배열로 읽기
        reader = new FileReader("c:/Temp/test.txt");
        char[] data = new char[100]; // 읽은 문자를 저장할 배열 생성
        while(true) {
            int num = reader.read(data); //읽은 문자는 배열에 저장, 읽은 문자 수는 리턴
            if(num == -1) break; //파일을 다 읽으면 while문 종료
            for(int i =0; i<num; i++){
                System.out.print(data[i]);
            }
        }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
