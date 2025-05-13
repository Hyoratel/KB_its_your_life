//개선 필요
//1. 계좌번호 중복 방지
//2. 계좌형태 지정
//3. 이름 예외처리
//4. 계좌 저장 갯수 변경
//5. 예외처리, 롬복 활용해서 변경

package ch06.Bank;

import java.util.Scanner;

public class BankApplication {
    //Account[]를 받아서 일치하는 계좌를 찾는 메서드(중복 방지)
    public static Account findAccountByNumber(Account[] accounts, int accountCount,Scanner sc ){
        while(true){
            System.out.println("계좌번호: ");
            String inputAccountNumber = sc.nextLine();

            for (int i = 0; i <accountCount; i++) {
                if(accounts[i].getAccountNumber().equals(inputAccountNumber)){
                    return accounts[i]; // 찾은 계좌 반환
                }
            }
            System.out.println("해당 계좌번호는 존재하지 않습니다. 다시 입력해주세요.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true; //반복 실행 제어
//        int[] accounts = null;
        //최대 100개 계좌 저장 배열 생성
        Account[] accounts = new Account[100];
        int accountCount = 0; // 현재 저장된 계좌 수

        while (run) {
            System.out.println("-----------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("-----------------------------------------------");
            System.out.println("선택> ");

            //사용자가 입력한 메뉴 선택값을 정수로 받는다.
            int menuNum = Integer.parseInt(sc.nextLine());

            switch (menuNum) {
                case 1: {//계좌생성 메뉴 선택시
                    System.out.println("----------");
                    System.out.println("계좌생성");
                    System.out.println("----------");

                    // 사용자에게 계좌번호 입력받기
                    // 예외처리 추가(에러발생시 해당입력칸으로
                    // 반복문이 실행되지 않을수도 있기때문에 초기화 필수!
                    String accNum = null;
                    String owner = null;
                    int balance = 0;

                    //계좌번호 입력
                    while (true) {
                        System.out.print("계좌번호: ");
                        accNum = sc.nextLine();
                        if(accNum.isEmpty()) {
                            System.out.println("계좌번호를 입력하세요.");
                            continue;
                        }
                        break;
                    }

                    while (true) {
                        System.out.print("계좌주: ");
                        owner = sc.nextLine();
                        if(owner.isEmpty()) {
                            System.out.println("이름을 입력하세요.");
                            continue;
                        }
                        break;
                    }

                    while (true) {
                        System.out.print("초기입금액: ");
                        try {
                            balance = Integer.parseInt(sc.nextLine());
                            if(balance < 0) {
                                System.out.println("0 이상 금액만 입력가능합니다.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("숫자 형식이 잘못되었습니다. 예: \"10000\" 형식으로 입력해주세요.");
                        }
                    }

                    Account acc = new Account(); // 기본 생성자
                    acc.setAccountNumber(accNum); //setter 사용해서 사용자가 입력한 값 설정
                    acc.setOwner(owner);
                    acc.deposit(balance); // 초기 입금은 deposit으로!

                    accounts[accountCount++] = acc;
                    System.out.println("결과: 계좌가 생성되었습니다.");
                    break; }

                case 2: //계좌목록 가져오기
                    System.out.println("----------");
                    System.out.println("계좌목록");
                    System.out.println("----------");
                    //사용자들이 입력한 계좌목록 가져오기(getter)
                    for (int i = 0; i < accountCount; i++) {
                        Account acc = accounts[i]; //배열에서 하나씩 꺼내기
                        System.out.println(acc.getAccountNumber()+" "+acc.getOwner()+" "+acc.getBalance());
                    }
                    break;

                case 3: { //예금
                    System.out.println("----------");
                    System.out.println("예금");
                    System.out.println("----------");
                    //계좌번호 검증은 메서드 호출로 중복 제거
                    Account target = findAccountByNumber(accounts, accountCount, sc);

//                    while (true) {
//                        System.out.print("계좌번호: ");
//                        //왜 여기서는 while문에 적기전에 초기화하지 않지??
//                        //inputAccountNumber는 while문 안에서만 사용하는 지역변수이기 때문에
//                        String inputAccoutNumber = sc.nextLine();
//
//                        //계좌 목록에서 입력한 계좌번호 찾기
//                        for (int i = 0; i < accountCount; i++) {
//                            if(accounts[i].getAccountNumber().equals(inputAccoutNumber)) {
//                                target = accounts[i];
//                                break;
//                            }
//                        }
//                        if (target == null) {
//                            System.out.println("해당 계좌번호는 존재하지 않습니다.");
//                            continue;
//                    }
//                        break;
//                    }
                    int depositAmount = 0;
                    while (true) {
                    System.out.print("예금액: ");
                    try {
                        depositAmount = Integer.parseInt(sc.nextLine());
                        if(depositAmount < 0) {
                            System.out.println("예금액은 1원 이상 금액만 입력가능합니다.");
                            continue; //다시 입력 받기
                        }
                        break; // 올바른값 입력시 루프탈출

                    } catch (NumberFormatException e) {
                        System.out.println("숫자 형식이 잘못되었습니다. 예: \"10000\" 형식으로 입력해주세요.");
                    }
                    }
                    target.deposit(depositAmount); // 예금 처리
                    System.out.println("입금 완료! 현재 잔액: "+target.getBalance()+"원");
                    break; }

                case 4: { //출금
                    System.out.println("----------");
                    System.out.println("출금");
                    System.out.println("----------");

                    //계좌 찾기 로직 재사용
                    Account target =findAccountByNumber(accounts, accountCount, sc);

                    //출금액 입력 & 유효성 검사
//                    int withdrawAmount = 0;
//                    while (true) {
//                        System.out.print("출금액: ");
//                        try{
//                            withdrawAmount = Integer.parseInt(sc.nextLine());
//                            if(withdrawAmount <= 0) {
//                                System.out.println("출금액은 1원 이상이어야 합니다.\n");
//                                continue;
//                            }
//                            if (withdrawAmount > target.getBalance()) {
//                                System.out.println("잔액이 부족합나다. 현재 잔액: "+target.getBalance());
//                                continue;
//                            }
//                            break;
//                        } catch (NumberFormatException e) {
//                            System.out.println("숫자 형식이 잘못되었습니다. 예: \"10000\" 형식으로 입력해주세요.");
//                        }
//                    }
//                    target.withdraw(withdrawAmount); // 출금 처리
//                    System.out.println("출금 완료! 현재 잔액: "+target.getBalance()+"원");
//                    break;

                    //출금 시도 & 예외처리
                    while(true){
                        System.out.print("출금액: ");
                        try{
                            int withdrawAmount = Integer.parseInt(sc.nextLine());
                            target.withdraw(withdrawAmount); // 출금 시도 -> 내부 예외 발생 가능
                            System.out.println("출금 완료! 현재 잔액: "+target.getBalance()+"원");
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("숫자 형식이 잘못되었습니다. 예: \"10000\" 형식으로 입력해주세요.");
                        } catch (IllegalArgumentException e){
                            System.out.println("입력 오류: "+e.getMessage());
                        } catch (InsufficientException e){
                            System.out.println("출금 실패: "+e.getMessage());
                        }
                    }
                    break;
                }
                case 5:
                    run = false;
                    break;
            }
        }
        System.out.println("프로그램 종료");
        sc.close();
    }
}
