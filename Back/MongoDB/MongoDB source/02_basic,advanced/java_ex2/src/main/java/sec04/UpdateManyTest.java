package sec04;

// MongoDB 관련 클래스 import
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import app.Database;

import static com.mongodb.client.model.Filters.gt;      // greater than 필터
import static com.mongodb.client.model.Updates.*;       // set, currentTimestamp 등 업데이트 연산

public class UpdateManyTest {
    public static void main(String[] args) {
        // users 컬렉션에서 여러 문서를 수정할 준비
        MongoCollection<Document> collection = Database.getCollection("users");

        // 조건: age가 16보다 큰 사용자만 선택
        int age = 16;
        Bson query = gt("age", age);

        // 수정 내용: name을 "modify name"으로 바꾸고, lastUpdated에 현재 시간 기록
        Bson updates = combine(
                set("name", "modify name"),
                currentTimestamp("lastUpdated")
        );

        // 조건에 맞는 문서 모두 수정
        UpdateResult result = collection.updateMany(query, updates);

        // 결과 출력: 실제로 수정된 문서 수
        System.out.println("==> UpdateManyResult : " + result.getModifiedCount());

        // 연결 종료
        Database.close();
    }
}
