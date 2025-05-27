package sec03;

// MongoDB 관련 클래스 import
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import app.Database;

import static com.mongodb.client.model.Filters.eq; // Bson 조건(eq)을 쉽게 작성하기 위해 import

public class FindOneTest {
    public static void main(String[] args) {
        // todo 컬렉션 객체 가져오기
        MongoCollection<Document> collection = Database.getCollection("todo");

        // 조회할 문서의 _id 값을 문자열로 준비 (예: Compass에서 복사한 ID)
        String id = "683528529c53566ed3065e9d"; // 실제 여러분의 데이터에 맞게 교체 필요

        // _id 필드에 해당 ObjectId가 있는 문서를 찾는 조건 생성
        Bson query = eq("_id", new ObjectId(id));

        // 조건에 맞는 첫 번째 문서를 찾아 반환 (없으면 null)
        Document doc = collection.find(query).first();

        // 결과 출력
        System.out.println("==> findByIdResult : " + doc);

        // 연결 종료
        Database.close();
    }
}
