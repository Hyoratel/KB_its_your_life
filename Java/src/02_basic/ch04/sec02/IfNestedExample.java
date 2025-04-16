package ch04.sec02;

public class IfNestedExample {
    public static void main(String[] args) {
        int score = (int)(Math.random()*100+1);
        System.out.println("점수:" + score);
        String grade;
        if (score <=100 && score >= 95){grade = "A+";}
        else if (score <=94 && score >= 90){grade = "A";}
        else if (score <=89 && score >= 85){grade = "B+";}
        else if (score <=84 && score >= 81){grade = "B";}
//        else 작성안하면 점수가 80점 이하일때가 미포함되서 grade가 초기화가 되지 않아 컴파일에러 발생
        else {grade = "C";}


        System.out.println("학점:"+ grade);
        }

    }

