package ch14.exam;

//방법2:Runnable 인터페이스를 구현해서 run() 메서드 정의 ->Thread 객체 넘김
public class MusicRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("음악을 재생합니다.");
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }
    }
}
