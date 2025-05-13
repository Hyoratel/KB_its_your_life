package ch13.sec02.exam01;

public class Product <K,M> {
    //객제치향 : 캡슐화(정보은닉)
    private K kind;
    private M model;

    //get ==> kind,model을 읽어오는 메서드 (리턴 필수)
    public K getKind() {return this.kind;}
    public M getModel() {return this.model;}
    //set ==> kind,model을 수정하는 메서드
    public void setKind(K kind){this.kind=kind;}
    public void setModel(M model){this.model=model;}
}
