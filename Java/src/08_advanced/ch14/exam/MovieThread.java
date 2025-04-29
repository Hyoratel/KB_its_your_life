package ch14.exam;

//스레드를 만드는 방법1: Thread 클래스를 상속해서 run() 메서드 오버라이딩
public class MovieThread extends Thread {
    @Override
    public void run() {
        for(int i=0; i<3; i++){
            System.out.println("동영상을 재생합니다.");
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
        }
    }
}
