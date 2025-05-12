package ch18.sec11;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws IOException {
        //File 객체 생성
        //경로만 설정, 아직 파일아니 폴더는 실제로 생성되지 않음.
        File dir = new File("c:/Temp/images"); //디렉토리 경로 지정
        File file1 = new File("C:/Temp/file1.txt"); //파일 경로 지정
        File file2 = new File("C:/Temp/file2.txt");
        File file3 = new File("C:/Temp/file3.txt");

        //존재하지 않으면 디렉토리 또는 파일 생성
        if(dir.exists() == false) {dir.mkdirs();} //상위 디렉토리까지 포함해서 디렉토리 생성
        if(file1.exists() == false){file1.createNewFile();} //빈파일 생성
        if(file2.exists() == false){file2.createNewFile();}
        if(file3.exists() == false){file3.createNewFile();}

        //Temp 폴더의 내용을 출력
        File temp = new File("C:/Temp");
        File[] contents = temp.listFiles(); //폴더 안의 파일/폴더 목록을 배열로 반환

        //날짜 및 시간 포맷 설정
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");

        //Temp 폴더의 항목들을 하나씩 출력
        for(File file : contents) {
            //파일의 마지막 수정일을 형식에 맞게 출력
            //왼쪽 정렬, 25자리 고정
            System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
            if(file.isDirectory()){ //폴더인지 파일인지 구분
                System.out.printf("%-10s%-20s", "<DIR>", file.getName()); //폴더면 <DIR> 표시
            } else {
                System.out.printf("%-10s%-20s", file.length(), file.getName()); //파일인 경우 크기(바이트) 이름 출력
            }
            System.out.println();
        }
    }
}
