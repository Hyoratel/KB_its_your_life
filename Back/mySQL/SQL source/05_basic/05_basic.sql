-- 1.tabledb 데이터베이스를 생성하세요.
-- *만일 이미 존재한다면 삭제
drop database if exists tabledb;
create database tabledb;

-- 2.usertbl테이블을 만드세요.
use tabledb;
create table usertbl(
	userId char(8) not null primary key,
	name varchar(10) not null,
	birthyear int not null,
	addr char(2) not null,
	mobile1 char(3) null,
	mobile2 char(8) null,
	height smallint null,
	mdate date null);

-- 3.buytbl테이블을 만드세요.
create table buytbl(
	num int not null primary key auto_increment,
	userid char(8) not null,
	prodname char(6) not null,
	groupname char(4) null,
	price int not null,
	amount smallint not null,
	foreign key(userid) references usertbl(userid)
);

-- 4.회원 테이블에 다음 데이터를 입력하세요.
insert into usertbl values('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
insert into usertbl values('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
insert into usertbl values('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

select * from usertbl;

-- 5. 구매테이블에 다음 데이터를 입력하세요.
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL, 30, 2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200, 1);  -- 에러발생
-- userid는 FK이므로 usertbl에 'JYP'가 있어야함.

-- 6.다음 컬럼을 가지는 usertbl을 정의하세요.
-- 기존 usertbl이 존재하는 경우 삭제
-- 기본키는 테이블 레벨에서 정의하고 제약조건명을 함께 지정. 
drop table if exists buytbl;
drop table if exists usertbl;
create table usertbl(
	userid char(8) not null,
	name varchar(10) not null,
	birthyear int not null,
CONSTRAINT PRIMARY KEY PK_userTBL_userID(userID) -- 제약조건 설정
-- PK_usertbl_userid : 제약조건 이름 / (userid) : 기본키로 지정할 컬럼
);
desc usertbl; -- 구조를 보는 명령어

-- 7. 다음 컬럼을 가지는 prodTBL을 정의하세요.
DROP TABLE IF EXISTS prodTbl;
CREATE TABLE prodTbl (
prodCode CHAR(3) NOT NULL,
prodID CHAR(4) NOT NULL,
prodDate DATETIME NOT NULL,
prodCur CHAR(10) NULL,
CONSTRAINT PK_prodTbl_proCode_prodID -- 복합기본키 설정
PRIMARY KEY (prodCode, prodID)
);
desc prodtbl;

-- 8. usertbl과 buytbl을 바탕으로 다음 결과가 나오는 뷰를 정의하세요.
-- 뷰는 하나의 가상 테이블로 실제 데이터를 저장하지 않고, select 쿼리 결과를 마치 테이블처럼 사용할 수 있게 만들어 놓은 것.
use sqldb;
CREATE VIEW v_userbuytbl -- 이름
AS
SELECT U.userid, U.name, B.prodName, U.addr, CONCAT(U.mobile1, U.mobile2) AS '연락처'
FROM usertbl U
INNER JOIN buytbl B
ON U.userid = B.userid;

select * from v_userbuytbl where name='김범수';