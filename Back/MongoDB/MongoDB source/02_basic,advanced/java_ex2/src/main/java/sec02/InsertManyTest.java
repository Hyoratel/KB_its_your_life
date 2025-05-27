package sec02;

// 필요한 클래스 import
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;
import app.Database;

import java.util.ArrayList;
import java.util.List;

public class InsertManyTest {
    public static void main(String[] args) {
        // todo 컬렉션 객체 가져오기
        MongoCollection<Document> collection = Database.getCollection("todo");

        // 여러 문서를 저장할 리스트 생성
        List<Document> insertList = new ArrayList<>();

        // 첫 번째 문서 생성
        Document document1 = new Document();
        document1.append("title", "MongoDB1");
        document1.append("desc", "MongoDB 공부하기1");
        document1.append("done", false);

        // 두 번째 문서 생성
        Document document2 = new Document();
        document2.append("title", "MongoDB2");
        document2.append("desc", "MongoDB 공부하기2");
        document2.append("done", true);

        // 리스트에 두 문서 추가
        insertList.add(document1);
        insertList.add(document2);

        // insertMany()로 리스트 전체를 한 번에 삽입
        InsertManyResult result = collection.insertMany(insertList);

        // 삽입된 문서들의 ID 출력
        System.out.println("==> InsertManyResult : " + result.getInsertedIds());

        // 연결 종료
        Database.close();
    }
}
