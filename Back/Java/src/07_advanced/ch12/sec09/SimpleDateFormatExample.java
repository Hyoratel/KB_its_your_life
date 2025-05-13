package ch12.sec09;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strNow1 = sdf.format(now);
        System.out.println(strNow1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
        String strNow2 = sdf2.format(now);
        System.out.println(strNow2);

        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy. MM. dd a hh:mm:ss");
        String strNow3 = sdf3.format(now);
        System.out.println(strNow3);

        SimpleDateFormat sdf4 = new SimpleDateFormat("오늘은 EEEE");
        String strNow4 = sdf4.format(now);
        System.out.println(strNow4);



    }
}
