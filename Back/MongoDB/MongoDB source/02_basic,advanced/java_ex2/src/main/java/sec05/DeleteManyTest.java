package sec05;

// MongoDB 관련 클래스 import
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import app.Database;

import static com.mongodb.client.model.Filters.gt;  // greater than 조건 필터

public class DeleteManyTest {
    public static void main(String[] args) {
        // users 컬렉션에서 여러 문서를 삭제할 준비
        MongoCollection<Document> collection = Database.getCollection("users");

        // 삭제 조건: age > 15
        int age = 15;
        Bson query = gt("age", age);  // age 필드가 15보다 큰 문서들 선택

        // deleteMany()로 조건을 만족하는 문서 전체 삭제
        DeleteResult result = collection.deleteMany(query);

        // 삭제된 문서 개수 출력
        System.out.println("==> DeleteManyResult : " + result.getDeletedCount());

        // 연결 종료
        Database.close();
    }
}
