package sec01;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
public class ConnectionTest {
    public static void main(String[] args) {
        // 접속할 MongoDB 서버의 주소와 포트를 포함한 URI 문자열
        String uri = "mongodb://127.0.0.1:27017"; // 로컬호스트에서 MongoDB 실행 중이어야 함
        String db = "todo_db";
        try (MongoClient client =MongoClients.create(uri)){
            MongoDatabase database = client.getDatabase(db);  // 지정한 이름의 데이터베이스 참조 가져오기

            System.out.println("Connected to database"); //test
        } catch(Exception e) {
            System.out.println("Error: " + e); //test
            e.printStackTrace();
        }
    }
}