package sec02;

// 필요한 MongoDB 및 Java 클래스 import
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;
import app.Database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertMany2Test {
    public static void main(String[] args) {
        // users 컬렉션 객체 가져오기
        MongoCollection<Document> collection = Database.getCollection("users");

        // 여러 문서를 저장할 리스트 생성
        List<Document> insertList = new ArrayList<>();

        // i = 10부터 20까지 반복 (10개 사용자 생성)
        for (int i = 10; i < 21; i++) {
            // 문서 하나 생성
            Document document = new Document();
            document.append("name", "user_" + i); // name 필드
            document.append("age", i);            // age 필드
            document.append("created", new Date()); // 현재 시간 (생성 시점 기록)

            // 리스트에 문서 추가
            insertList.add(document);
        }

        // 문서 리스트 전체를 insertMany로 삽입
        InsertManyResult result = collection.insertMany(insertList);

        // 삽입된 문서들의 ID 출력
        System.out.println("==> InsertManyResult : " + result.getInsertedIds());

        // 연결 종료
        Database.close();
    }
}
