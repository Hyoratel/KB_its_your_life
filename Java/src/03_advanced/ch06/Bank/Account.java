package ch06.Bank;

import java.util.Scanner;

//계좌는 Account에서 객체로 생성
//계좌 클래스 : 계좌번호, 계좌주, 잔액 정보
public class Account {
    private String accountNumber; //계좌번호
    private String owner; //계좌주 이름
    private int balance; // 현재 잔액

    //생성자 : 계좌번호, 계좌주, 초기잔액을 받아 초기화
    public Account(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }
    public Account(){} //기본 생성자(setter 활용 계좌설정을 위함)

    //getter : 계좌번호 반환
    public String getAccountNumber() {
        return accountNumber;
    }
    //setter : 계좌번호 설정
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    //getter : 계좌주 이름 반환
    public String getOwner() {
        return owner;
    }
    //setter : 계좌주 이름 설정
    public void setOwner(String owner) {
        this.owner = owner;
    }
    //getter : 현재 잔액 반환
    public int getBalance() {
        return balance;
    }
    //setter : 잔액 설정(0이상일때만 허용)
    public void setBalance(int balance) {
        if(balance >= 0){
            this.balance = balance;
        } else {
            System.out.println("초기 잔액은 0 이상이어야 합니다.");
    }}
    //예금 기능: 금액만큼 잔액 증가
    public void deposit(int amount) {
        if(amount > 0){
            balance += amount;
        } else {
            System.out.println("입금액은 0보다 커야 합니다.");
        }

    }
    //출금 기능:금액만큼 잔액 감소(출금액이 잔액을 넘을 순 없음)
    public void withdraw(int amount) {
        if(balance >= amount){
            balance -= amount;
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }
}
