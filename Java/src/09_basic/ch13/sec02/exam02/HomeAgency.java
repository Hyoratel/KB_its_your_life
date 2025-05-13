package ch13.sec02.exam02;

public class HomeAgency implements Rentable<Home>{
    @Override
    public Home rent() {
        return new Home();
        //Rentable<Home>을 구현해서 rent() 메소드가 Home 객체를 새로 만들어서 반환
    }
}
