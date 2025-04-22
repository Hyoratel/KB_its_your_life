package ch07.exam;

public class InputTest {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("이름: ");
        //String name = scanner.nextLine();
        String name = Input.read("이름: ");
        System.out.println("입력값: " + name);
        
        String name2 = Input.read("이름", "홍길동");
        System.out.println("입력값: " + name2);
        int age = Input.readInt("나이: ");
        System.out.println("입력값: " + age);
        boolean answer = Input.confirm("종료할까요?");
        System.out.println("입력값: " + answer);
        boolean answer2 = Input.confirm("종료할까요?", true);
        System.out.println("입력값: " + answer2);

    }
}
