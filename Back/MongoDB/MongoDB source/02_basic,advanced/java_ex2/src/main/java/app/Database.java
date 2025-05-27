/** Database.java 역할
 * MongoDB 연결을 공통으로 관리하는 헬퍼클래스(유틸클래스)
 * JDBC에서 JDBCUtil.getConnection()처럼 사용하는 개념
  */
package app;

// MongoDB 드라이버 관련 클래스 import
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Database {
    // MongoDB 클라이언트 및 데이터베이스를 정적(static)으로 선언 (애플리케이션 전체에서 공유)
    static MongoClient client;
    static MongoDatabase database;

    // 클래스가 처음 로딩될 때 실행되는 static 초기화 블록
    // 데이터베이스 연결 및 DB 참조 설정
    static {
        // MongoDB 서버 연결 문자열 지정
        ConnectionString connectionString = new ConnectionString("mongodb://127.0.0.1:27017");

        // 클라이언트 생성
        client = MongoClients.create(connectionString);

        // 사용할 데이터베이스 선택 (todo_db가 없으면 자동 생성됨)
        database = client.getDatabase("todo_db");
    }

    // MongoDB 연결 종료 메서드 (명시적으로 닫고자 할 때 사용)
    public static void close() {
        client.close();
    }

    // 현재 연결된 데이터베이스 객체 반환
    public static MongoDatabase getDatabase() {
        return database;
    }

    // 컬렉션 이름을 받아 해당 컬렉션(Document 타입)을 반환
    public static MongoCollection<Document> getCollection(String colName) {
        MongoCollection<Document> collection = database.getCollection(colName);
        return collection;
    }
}
