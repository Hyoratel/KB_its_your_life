package ch06.exam;

class Database {
    private String connection = "MySQL";

    private static Database database = new Database(); // private 접근 권한을 갖는 정적 필드 선언과 초기화
    private Database() {} // private 접근 권한을 갖는 생성자 선언
    public static Database getInstance() { //public 접근 권한을 갖는 정적 메소드 선언
        return database;
    }

    public String connect() {
        System.out.println(connection + "에 연결합니다.");
        return connection;
    }
    public void close() {
        System.out.println(connection + "을 닫습니다.");
    }
    public String getConnection() {
        return connection;
    }
}
