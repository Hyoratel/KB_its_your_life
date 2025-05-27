package sec04;

// MongoDB 관련 클래스 import
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import app.Database;

// update 연산 관련 static 메서드 모음
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

public class UpdateOneTest {
    public static void main(String[] args) {
        // users 컬렉션에서 문서 하나 가져올 준비
        MongoCollection<Document> collection = Database.getCollection("users");

        // 업데이트할 문서의 _id (MongoDB Compass 등에서 복사해서 입력)
        String id = "68356dc9694bc81049af204e"; // 실제 존재하는 ObjectId로 교체해야 함

        // 조건: _id 필드가 위 id와 같은 문서
        Bson query = eq("_id", new ObjectId(id));

        // 수정할 내용: name 필드를 "modify name"으로 변경하고, lastUpdated를 현재 시간으로 설정
        Bson updates = combine(
                set("name", "modify name"),               // name 필드 변경
                currentTimestamp("lastUpdated")           // 현재 시간으로 lastUpdated 필드 설정
        );

        // 문서 하나만 수정
        UpdateResult result = collection.updateOne(query, updates);

        // 결과 출력: 실제로 수정된 문서 수
        System.out.println("==> UpdateResult : " + result.getModifiedCount());

        // 연결 종료
        Database.close();
    }
}
