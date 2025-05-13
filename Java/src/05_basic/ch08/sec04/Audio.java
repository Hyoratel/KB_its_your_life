package ch08.sec04;

public class Audio implements RemoteControl {
    private int volume;

    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
    }

    @Override
    // 매개변수 volume 값으로 필드 volume 값으로 설정
    public void setVolume(int volume) {
            // 매개변수 volume 값이 최대 볼륨보다 큰 값이면 최대 볼륨으로 설정
            if(volume>RemoteControl.Max_Volume){
                this.volume = RemoteControl.Max_Volume;
                // 최소 볼륨보다 작은 값이면 최소 볼륨으로 설정
            } else if(volume<RemoteControl.Min_Volume){
                this.volume = RemoteControl.Min_Volume;
            } else{
                this.volume = volume;
            }
            // "현재 TV 볼륨: 값" 출력
            System.out.println("현재 Audio 볼륨: " + this.volume);
        }
    }
