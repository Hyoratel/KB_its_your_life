-- 1.sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl1을 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
use sqldb;

create table tbl1(
	a int primary key,
    b int,
    c int
    );
    
show index from tbl1;

-- 2.sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl2를 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
create table tbl2(
	a int primary key,
    b int unique,
    c int unique,
    d int
    );
show index from tbl2;

-- 3.sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl3를 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
create table tbl3(
	a int unique,
    b int unique,
    c int unique,
    d int
    );
show index from tbl3;

-- 4.sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl4를 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
create table tbl4(
	a int unique not null,
	b int unique,
	c int unique,
	d int
	);
show index from tbl4;

-- 5.sqldb 데이터베이스에 다음과 같은 컬럼을 가지는 테이블 tbl5를 생성하고, 자동 생성된 인덱스 목록을 확인하세요.
create table tbl5(
	a INT UNIQUE NOT NULL,
	b INT UNIQUE,
	c INT UNIQUE,
	d INT PRIMARY KEY
    );
show index from tbl5;

-- 6.testdb에 다음 컬럼 목록을 가지는 usertbl을 만드세요.
-- 컬럼 목록
create database if not exists testdb;

use testdb;

drop table if exists usertbl;
create table usertbl(
	userID CHAR(8) NOT NULL PRIMARY KEY,
	name VARCHAR(10) NOT NULL,
	birthYear INT NOT NULL,
	addr NCHAR(2) NOT NULL
    );
desc usertbl;

-- 7. 아래 데이터를 추가하고, 클러스터형 인덱스의 테이블의 내용을 확인하세요.
insert into usertbl values('LSG', '이승기', 1987, '서울');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울');

select * from usertbl;

-- 8. ALTER를 사용하여 usertbl에서 PRIMARY KEY 제약조건을 제거하고, name 컬럼에 pk_name이라는 제약조건명으로 기본키를 설정하세요.
alter table usertbl
drop primary key;

alter table usertbl
add constraint PK_name primary key(name);

-- 9.usertbl의 내용을 출력하여, 새로운 클러스터형 인덱스를 확인하세요.
desc usertbl;
select * from usertbl;


