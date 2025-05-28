# 📘 JDBC 프로그래밍 - Travel 프로젝트 구조 및 흐름 정리

이 문서는 `08 Java 연동 JDBC 프로그래밍 - Travel(기본)` 및 `Travel(심화)` PDF 실습 자료를 기반으로 작성되었습니다.

---

## 📁 프로젝트 전체 흐름 개요

JDBC를 이용해 관광지 데이터를 DB에 저장하고,  
콘솔 UI를 통해 다양한 방식으로 출력하는 프로젝트입니다.

## 🔄 데이터 흐름
```sql
+---------------------+
|  CSV / 이미지 파일  |
+---------------------+
|
v
+-----------------------------+
|  TravelVO, TravelImageVO   |
|  (CSV → 객체 변환)         |
+-----------------------------+
|
v
+-----------------------------+
|   TravelDaoImpl            |
|   (insert 메서드로 SQL 실행) |
+-----------------------------+
|
v
+-----------------------------+
|     MySQL DB               |
| (tbl_travel, tbl_travel_image) |
+-----------------------------+
|
v
+-----------------------------+
|    TravelServiceImpl       |
| (DAO 호출하여 데이터 조회)  |
+-----------------------------+
|
v
+-----------------------------+
|         TravelApp          |
| (사용자 입력 → 기능 실행)   |
+-----------------------------+

```
---

## 🧩 실제 프로젝트 디렉토리 구조
```
org.scoula.travel
├── domain
│   ├── TravelVO.java           ← 관광지 데이터 VO
│   └── TravelImageVO.java      ← 이미지 파일 VO
│
├── dao
│   ├── TravelDao.java          ← DAO 인터페이스
│   └── TravelDaoImpl.java      ← SQL 실행 구현체
│
├── service
│   ├── TravelService.java      ← 서비스 인터페이스
│   └── TravelServiceImpl.java  ← 서비스 로직 구현
│
└── app
├── MenuItem.java           ← 콘솔 메뉴 항목 정의
└── TravelApp.java          ← 전체 콘솔 앱 실행
```
---

## ⚙️ 기타 핵심 파일

- `JDBCUtil.java`: DB 연결/해제 전담 유틸
- `application.properties`: DB 접속 정보
- `build.gradle`: 의존성 관리
  - opencsv, mysql-connector-j, lombok 등

---

## ✅ 교안별 학습 목적

### 1. 기본편 (`Travel(기본)_정답.pdf`) - ✅ 완료됨

| 항목 | 설명 |
|------|------|
| CSV 파일 읽기 | `CsvToBeanBuilder`로 VO 리스트 생성 |
| VO 정의 | `TravelVO`, `TravelImageVO` |
| DB 테이블 생성 | `tbl_travel`, `tbl_travel_image` 생성 및 외래키 설정 |
| DAO 구현 | `insert()`, `insertImage()` |
| 데이터 삽입 | `ImportTravelData.java`, `ImportImageData.java` 실행으로 DB에 데이터 저장 |

---

### 2. 심화편 (`Travel(심화)_정답.pdf`) - 🔜 실습 시작

| 기능 | 메서드 | 설명 |
|------|--------|------|
| 전체 목록 출력 | `printTravels()` | 관광지 목록 (no, district, title) 출력 |
| 권역별 목록 출력 | `printTravelsByDistrict()` | 권역 선택 → 해당 관광지 출력 |
| 페이지별 목록 출력 | `printTravelsByPage()` | 전체 페이지 수 표시 → 페이지 번호 입력 시 출력 |
| 관광지 상세 보기 | `printTravel()` | 번호 입력 → 상세 정보 + 이미지 출력 |
| 콘솔 UI 구성 | `TravelApp`, `MenuItem` | 메뉴 기반으로 기능 실행 구조 구성 |

---

## ▶️ 다음 실습 순서 (심화편)

1. `TravelServiceImpl.java`에서 조회 기능 구현 점검
2. `TravelApp.java`로 콘솔 메뉴 작동 확인
3. `Optional<TravelVO>` 및 예외 처리 로직 확인
4. DAO 쿼리 구조 (`JOIN`, `DISTINCT`, `LIMIT`, `ORDER BY`) 복습

---