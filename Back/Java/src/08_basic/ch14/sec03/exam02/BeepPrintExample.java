package ch14.sec03.exam02;

import java.awt.Toolkit;

public class BeepPrintExample implements Runnable {
    // 작업1: 0.5초 간격으로 비프음 출력 (작업 스레드에서 실행)
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();  // 비프음 출력
            try {
                Thread.sleep(500); // 0.5초 정지
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 작업1: Runnable 스레드 실행
        Thread thread = new Thread(new BeepPrintExample());
        thread.start();

        // 작업2: 메인 스레드에서 "띵" 문자열 출력
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500); // 0.5초 정지
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
