//자바의 scanner를 직접 다루지 않고, 사용자가 입력한 문자열/숫자/yes/no 값을 편리하게 받아들이기 위한 도우미 메서드를 만들고 사용하는 방법을 보여주는 것.
package ch07.exam;

import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);

// String read(String title)
//  ⁃ 매개변수 title을 출력하고 (줄바꿈하지 않음), 사용자가 입력한 문자열을 리턴함
// String read(String title, String defaultValue)
//  ⁃ 매개변수 title(defaultValue)를 출력하고 (줄바꿈하지 않음), 사용자가 입력한 문자열을 리턴함, 그냥 엔터를 치면 defaultValue를 리턴
    public static String read(String title){
        System.out.print(title);
        return sc.nextLine();
    }
    public static String read(String title,String defaultValue){
        System.out.printf("%s(%s): ",title,defaultValue);
        String answer = sc.nextLine();

        return answer.isEmpty() ? defaultValue : answer;
    }

// int readInt(String title)
//  ⁃ 매개변수 title을 출력하고 (줄바꿈하지 않음), 사용자가 입력한 문자열을 정수로 변환 후 리턴함
    public static int readInt(String title){
        System.out.print(title);
        int answer = sc.nextInt();
        sc.nextLine(); // 엔터 제거
        return answer;
    }

//    yes/no 확인
// boolean confirm(String title, boolean defaultValue)
//  ⁃ 매개변수 title (Y/n)을 출력하고 (줄바꿈하지 않음),
//  ⁃ defaultValue가 true이면 (Y/n), false이면 (y/N)을 출력
//  ⁃ 입력 없이 엔터를 친 경우 기본값 리턴
// boolean confirm(String title)
//  ⁃ 앞에서 정의한 confirm을 호출하여 그 결과를 리턴
    public static boolean confirm(String title, boolean defaultValue){
        String yesNo = defaultValue ? "(Y/n)" : "(y/N)";
        System.out.printf("%s%s: ",title,yesNo);

        String answer = sc.nextLine();
        if(answer.isEmpty())
            return defaultValue;

            return answer.equalsIgnoreCase("y");
    }
    public static boolean confirm(String title){
        return confirm(title, true);
    }
}
