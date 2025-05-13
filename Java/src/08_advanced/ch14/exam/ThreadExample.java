package ch14.exam;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new MovieThread();
        thread1.start(); //run() 실행(새 스레드 시작)

        Thread thread2 = new Thread(new MusicRunnable()); //Runnable을 Thread에 감싸서 실행
        thread2.start();
    }
}

// Thread 상속 vs Runnable 구현
// Thread 상속
// 장점 : 코드 간단, 바로 실행 가능 / 단점 : 이미 다른클래스를 상속받고 있다면 사용 불가

// Runnable 구현
// 장점 : 다른 클래스와 동시 상속 가능, 더 유연 / 단점 : Thread로 감싸줘야 실행 가능