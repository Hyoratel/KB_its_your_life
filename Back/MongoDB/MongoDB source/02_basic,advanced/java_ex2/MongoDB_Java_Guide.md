# MongoDB Java 연동 실습 가이드 (기본편)

이 문서는 MongoDB를 Java에서 연동하는 실습 교안을 바탕으로 학습 순서와 각 단계의 내용을 정리한 것입니다. JDBC 프로그래밍과 유사한 구조를 가지고 있으며, Java 기반 NoSQL 연동 방식에 대한 기초를 익히는 데에 목적이 있습니다.

---

## ✅ 추천 학습 순서 및 흐름

### 1단계: 프로젝트 환경 준비

- `build.gradle`에 MongoDB 드라이버와 로깅 라이브러리 추가
- `logback.xml`을 `resources` 폴더에 배치하여 로깅 설정 구성

### 2단계: MongoDB 연결 코드 학습

- `ConnectionTest.java`에서 기본 연결 코드 테스트
- `Database.java`에 공통 연결 헬퍼 클래스 구성

### 3단계: 데이터 삽입

- `InsertOneTest`: 단일 문서 삽입 (`insertOne`)
- `InsertManyTest`: 다중 문서 삽입 (`insertMany`)
- `InsertMany2Test`: 루프를 이용한 사용자 데이터 삽입

### 4단계: 데이터 조회

- `FindTest`: 전체 문서 조회 (`collection.find()`)
- `FindOneTest`: `_id`로 단일 문서 조회

---

## 🔄 JDBC와 비교

| JDBC                            | MongoDB Java Driver                    |
| ------------------------------- | -------------------------------------- |
| `DriverManager.getConnection()` | `MongoClients.create(uri)`             |
| `PreparedStatement`             | `Document` 및 `Bson` 쿼리 객체         |
| `ResultSet`                     | `FindIterable<Document>` + 반복자 사용 |

---

## 📘 학습 순서 요약

| 단계 | 학습 주제                     | 파일명 / 클래스               |
| ---- | ----------------------------- | ----------------------------- |
| 1    | build.gradle 및 logback 설정  | `build.gradle`, `logback.xml` |
| 2    | 연결 테스트                   | `ConnectionTest.java`         |
| 3    | DB 클래스 구성 (JDBCUtil처럼) | `Database.java`               |
| 4    | 단일 삽입                     | `InsertOneTest.java`          |
| 5    | 다중 삽입                     | `InsertManyTest.java`         |
| 6    | 루프 이용 삽입                | `InsertMany2Test.java`        |
| 7    | 전체 문서 조회                | `FindTest.java`               |
| 8    | ID로 단일 문서 조회           | `FindOneTest.java`            |

---

## 📂 시작 파일 준비 확인

- [x] `build.gradle`에 의존성 설정 완료
- [x] `logback.xml` 로깅 설정 파일 준비 완료
- [x] `ConnectionTest.java` 연결 테스트
- [x] `Database.java` 공통 DB 유틸리티 구현
- [x] 데이터 삽입 및 조회 실습

---

# MongoDB Java 연동 실습 가이드 (심화편)

이 장에서는 MongoDB 데이터를 **수정(Update)하고 삭제(Delete)**하는 방법을 실습합니다.  
조건 기반으로 여러 문서를 처리하는 방법까지 확장됩니다.

## ✅ 추천 학습 순서 및 흐름

### 5단계: 데이터 수정 (Update)

- `UpdateOneTest`: `_id` 기준으로 단일 문서 수정 (`updateOne`)
- `UpdateManyTest`: 조건(`gt("age", 16)`)에 맞는 여러 문서 수정 (`updateMany`)

### 6단계: 데이터 삭제 (Delete)

- `DeleteOneTest`: `_id` 기준으로 단일 문서 삭제 (`deleteOne`)
- `DeleteManyTest`: 조건(`gt("age", 15)`)에 맞는 여러 문서 삭제 (`deleteMany`)

---

## 📘 심화 학습 순서 요약

| 단계 | 학습 주제                  | 파일명 / 클래스       |
| ---- | -------------------------- | --------------------- |
| 9    | 단일 문서 수정             | `UpdateOneTest.java`  |
| 10   | 조건에 맞는 다중 문서 수정 | `UpdateManyTest.java` |
| 11   | 단일 문서 삭제             | `DeleteOneTest.java`  |
| 12   | 조건에 맞는 다중 문서 삭제 | `DeleteManyTest.java` |

---

## 📂 진행 상황 체크리스트

- [x] `UpdateOneTest.java` 문서 수정 기능 구현
- [x] `UpdateManyTest.java` 조건 수정 기능 구현
- [x] `DeleteOneTest.java` 단일 삭제 기능 구현
- [x] `DeleteManyTest.java` 조건 삭제 기능 구현
