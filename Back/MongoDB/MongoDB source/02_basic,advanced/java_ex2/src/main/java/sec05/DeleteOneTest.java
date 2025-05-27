package sec05;

// MongoDB 관련 클래스 import
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import app.Database;

import static com.mongodb.client.model.Filters.eq;

public class DeleteOneTest {
    public static void main(String[] args) {
        // users 컬렉션에서 문서 하나 삭제할 준비
        MongoCollection<Document> collection = Database.getCollection("users");

        // 삭제할 대상 문서의 _id 값 (MongoDB Compass에서 복사)
        String id = "68356dc9694bc81049af2044"; // 존재하는 _id로 교체해야 정상 작동

        // 조건: _id 필드가 위 ID와 같은 문서
        Bson query = eq("_id", new ObjectId(id));

        // deleteOne()으로 해당 문서 삭제
        DeleteResult result = collection.deleteOne(query);

        // 삭제된 문서 수 출력 (1이면 삭제 성공, 0이면 조건에 맞는 문서 없음)
        System.out.println("==> DeleteResult : " + result.getDeletedCount());

        // 연결 종료
        Database.close();
    }
}
