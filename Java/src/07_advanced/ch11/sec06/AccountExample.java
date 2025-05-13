package ch11.sec06;

public class AccountExample {
    public static void main(String[] args){
        Account account = new Account(); // Account 클래스의 인스턴스 생성
        //예금
        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance());

        //출금
        try{
            account.withdraw(5000);
            System.out.println("출금성공: " + account.getBalance());
            account.withdraw(7000);
            System.out.println("출금성공: " + account.getBalance());
        } catch (InsufficientException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
}
