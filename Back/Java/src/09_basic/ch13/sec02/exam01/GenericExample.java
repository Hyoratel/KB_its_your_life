package ch13.sec02.exam01;

public class GenericExample {
    public static void main(String[] args) {
        //K는 Tv로 대체, M은 String으로 대체
        Product<Tv, String>product1 = new Product<>();

        //Setter 매개값은 반드시 Tv 와 String을 제공
        product1.setKind(new Tv()); //새로운 Tv 객체를 메모리에 만들어서 넘긴것
        product1.setModel("스마트Tv"); //문자열을 전달하는 것

        Tv tv = product1.getKind();
        String tvModel = product1.getModel();

        Product<Car, String> product2 = new Product<>();
        product2.setKind(new Car());
        product2.setModel("SUV자동차");

        Car car = product2.getKind();
        String carModel = product2.getModel();
    }
}
