// Document 객체 생성 -> MongoDB 컬렉션에 삽입
package sec02;

// 필요한 MongoDB 클래스 import
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import app.Database; // 우리가 만든 공통 유틸리티 클래스 사용

public class InsertOneTest {
    public static void main(String[] args) {
        // todo 컬렉션 객체 가져오기 (없으면 자동 생성됨)
        MongoCollection<Document> collection = Database.getCollection("todo");

        // 삽입할 문서를 Document 객체로 생성
        Document document = new Document();

        // 필드 추가: title, desc, done
        document.append("title", "MongoDB");
        document.append("desc", "MongoDB 공부하기");
        document.append("done", false);

        // insertOne()으로 문서 1개를 컬렉션에 삽입하고, 결과 객체를 반환
        InsertOneResult result = collection.insertOne(document);

        // 삽입된 문서의 ID(ObjectId) 출력
        System.out.println("==> InsertOneResult : " + result.getInsertedId());

        // 연결 종료 (명시적으로 닫고 싶을 경우)
        Database.close();
    }
}
