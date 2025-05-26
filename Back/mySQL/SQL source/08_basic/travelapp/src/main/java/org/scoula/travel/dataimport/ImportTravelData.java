package org.scoula.travel.dataimport;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.scoula.database.JDBCUtil;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.TravelVO;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

// 여행지 데이터를 CSV에서 불러와 DB에 저장하는 메인 클래스
public class ImportTravelData {
    public static void main(String[] args) throws CsvValidationException, IOException {

        //DAO 객체 생성: 데이터베이스 작업을 수행할 DAO 구현체 사용
        TravelDao dao = new TravelDaoImpl();

        //travel.csv 파일을 읽고, 각 행을 TravelVO 객체로 변환하여 리스트로 반환
        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
                .withType(TravelVO.class) //TravelVO 클래스를 기준으로 매핑
                .build()
                .parse();

        //travels 리스트에 있는 각 TravelVO 객체를 DB에 insert
        travels.forEach(travel -> {
            System.out.println(travel); //객체 내용 콘솔 출력(디버깅)
            dao.insert(travel); //각 객체 DB에 저장
        });

        //사용한 DB 연결 종료(JDBCUtil 내부에서 Connerction 자원 해제)
        JDBCUtil.close();

    }
}
