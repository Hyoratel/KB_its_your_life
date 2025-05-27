package sec03;

// MongoDB 관련 클래스 import
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import app.Database;

import java.util.Iterator;

public class FindTest {
    public static void main(String[] args) {
        // todo 컬렉션 객체 가져오기
        MongoCollection<Document> collection = Database.getCollection("todo");

        // find()로 컬렉션 전체 문서 조회 (조건 없음 = 전체 조회)
        FindIterable<Document> docList = collection.find();

        // 반복자를 이용해 문서 하나씩 순회 출력
        Iterator<Document> itr = docList.iterator();
        while (itr.hasNext()) {
            Document doc = itr.next();
            System.out.println(" ==> findResultRow : " + doc.toJson());
        }

        // 연결 종료
        Database.close();
    }
}
