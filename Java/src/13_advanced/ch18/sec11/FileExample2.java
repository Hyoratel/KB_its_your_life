package ch18.sec11;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample2 {
    public static void main(String[] args) throws Exception {
        //File 객체 생성
        File dir = new File("C:/Temp/images");

        //존재하지 않으면 디렉토리 또는 파일 생성
        if(dir.exists() == false) {
            dir.mkdirs();
        }

        //Temp 폴더 내용 출력
        File temp = new File("C:/Temp");
        File[] contents = temp.listFiles();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        for(File file : contents) {
            System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
            if(file.isDirectory()){
                System.out.printf("%-10s%-20s", "<DIR>", file.getName());
            } else {
                System.out.printf("%-10s%-20s", "file.length()", file.getName());
            }
            System.out.println();
        }
    }
}
