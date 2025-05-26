
# JDBC 프로그래밍 - Travel 프로젝트 구조 및 흐름 정리

이 문서는 `08 Java 연동 JDBC 프로그래밍 - Travel(기본)` PDF 실습 자료를 기반으로 한 학습 정리입니다.

---

## 📌 JDBC 개요

JDBC(Java Database Connectivity)는 Java 애플리케이션과 데이터베이스(DB)를 연결하여 SQL을 실행할 수 있도록 하는 API입니다.

---

## 📁 프로젝트 전체 구성도

```
JDBCUtil.java            ← DB 연결/닫기 전담
application.properties   ← DB 접속 정보 저장
↓
DAO (TravelDao, TravelDaoImpl) ← SQL 처리 로직 (insert, select 등)
↓
CSVTest, Import 실행 클래스 ← 기능 실행/테스트
```

---

## 🔹 주요 파일별 역할

### 1. `JDBCUtil.java`
- DB 연결 및 자원 해제 담당
- `application.properties`에서 설정 값을 읽어 연결
- 사용 예: `Connection conn = JDBCUtil.getConnection();`

### 2. `application.properties`
- DB 접속 설정 보관
```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/데이터베이스명
id=아이디
password=비밀번호
```

### 3. `build.gradle`
- 외부 라이브러리 설정:
  - opencsv (CSV 파일 파싱)
  - mysql-connector-j (MySQL 연동)
  - lombok (코드 자동 생성)

### 4. `CSVTest1.java`
- travel.csv를 한 줄씩 읽고 출력

### 5. `TravelVO.java`
- CSV 파일의 각 행을 Java 객체로 표현
- 필드: `no`, `district`, `title`, `description`, `address`, `phone`

### 6. `CSVTest2.java`
- CSV → `TravelVO` 리스트로 변환
- `CsvToBeanBuilder` 사용

### 7. SQL 테이블 정의
- `tbl_travel`: 관광지 정보 저장
- `tbl_travel_image`: 이미지 정보 저장 (`travel_no`는 외래키)

### 8. `TravelDao.java`
- DAO 인터페이스 (DB 작업 선언)
```java
void insert(TravelVO travel);
void insertImage(TravelImageVO image);
```

### 9. `TravelDaoImpl.java`
- 실제 SQL 실행 처리 구현 클래스
- `insert`, `getTravels`, `getTravel`, `getDistricts` 등 구현

### 10. `ImportTravelData.java`
- `travel.csv` 데이터를 DB의 `tbl_travel` 테이블에 insert

### 11. `ImportImageData.java`
- `travel-image` 폴더 이미지 파일명을 분석해 `tbl_travel_image`에 insert

---

## 🔁 JDBC 실습 흐름

1. DB 연결 도구 준비 → `JDBCUtil`, `application.properties`
2. CSV 읽기 → `CSVTest1`, `CSVTest2`
3. 테이블 생성 (SQL)
4. VO 및 DAO 정의 → `TravelVO`, `TravelDao`, `TravelDaoImpl`
5. DB 저장 실행 → `ImportTravelData`, `ImportImageData`
6. 조회 기능 구현 → `getTravels()`, `getTravel()` 등

---

## 📌 추후 학습 추천

- `prepare → bind → execute` 흐름 완벽히 이해하기
- 트랜잭션 관리 및 예외 처리 학습
- MVC 아키텍처 적용 실습
