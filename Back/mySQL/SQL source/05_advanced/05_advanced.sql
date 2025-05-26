use tabledb;

-- 1.다음 컬럼을 가지는 userTBL과 buyTBL을 정의하세요.
-- *기존에 테이블이 존재하면 삭제
drop table if exists usertbl;
create table usertbl(
	userid char(8) not null primary key,
	name varchar(10) not null,
	birthyear int not null
);

desc usertbl;

drop table if exists buytbl;
create table buytbl(
	num int not null primary key auto_increment,
	userid char(8) not null,
	prodname char(6) not null
);

desc buytbl;

-- alter이용해 userid를 외래키로 수정
alter table buytbl
add constraint FK_usertbl_buytbl
foreign key(userid)
references usertbl(userid);

-- 2. 다음 조건을 만족하는 userTBL 테이블을 정의하세요.
-- 기존 buytbl, usertbl을 삭제하세요.
drop table buytbl;
drop table usertbl;
create table usertbl(
	userid char(8) not null,
	name varchar(10) not null,
	birthyear int not null,
	email char(30) null unique,
	constraint primary key PK_usertbl_userid(userid)
);
desc usertbl;

-- 3.다음 조건을 만족하는 usertbl 테이블을 정의하세요.
-- 기존 usertbl 삭제
drop table usertbl;
create table usertbl(
	userid char(8) not null primary key,
	name varchar(10),
	birthyear int check(birthyear >= 1900 and birthyear <= 2023),
	mobile1 char(3) not null
    constraint CK_name check(name is not null)
);
desc usertbl;

-- 4. 다음 조건을 만족하는 usertbl 테이블 정의
-- 기존 usertbl 삭제
drop table usertbl;
create table usertbl(
	userid char(8) not null primary key,
	name varchar(10) not null,
	birthyear int not null default -1,
	addr char(2) not null default '서울',
	mobile1 char(3) null,
	mobile2 char(8) null,
	height smallint null default 170,
	mdate date null
);
desc usertbl;

-- 5.앞에서 만든 usertbl에 대해서 다음 조건을 처리하도록 수정하세요.
-- mobile1 컬럼 삭제
alter table usertbl
drop column mobile1;

-- name 컬럼명을 uname으로 변경
alter table usertbl
change column name uname varchar(10) null;

-- 기본키를 제거
alter table usertbl
drop primary key;
desc usertbl;

-- 뷰(심화2)
use employees;
-- 1. 다음 정보를 가지는 직원 정보를 출력하는 employees_info 뷰를 작성하세요.
create or replace view employees_info as
	select e.*,
    t.title,t.from_date t_from,t.to_date t_to,
    s.salary,s.from_date s_from,s.to_date s_to
    from employees e
    inner join titles t
    on e.emp_no = t.emp_no
    inner join salaries s
    on e.emp_no = s.emp_no;
select * from employees_info;

-- 2. employees_info 뷰에서 재직자의 현재 정보만 출력하세요.
select *
from employees_info
where s_to = '9999-01-01';

-- 3. 다음 정보를 가지는 부서 정보를 출력하는 emp_dept_info 뷰를 작성하세요.
-- 문제에 나오는 표랑 값이 다름
-- 추가적으로 다른 부서는 왜 안나오지???

CREATE OR REPLACE VIEW EMP_DEPT_INFO
AS
SELECT e.emp_no, d.dept_no, d.dept_name, de.from_date, de.to_date
FROM employees e
INNER JOIN dept_emp de
ON e.emp_no = de.emp_no
INNER JOIN departments d
ON de.dept_no = d.dept_no;

select * from emp_dept_info;

-- 4. emp_dept_info로 현재 재직자의 부서 정보를 출력하세요.
select *
from emp_dept_info
where to_date = '9999-01-01';

SELECT DISTINCT dept_no FROM dept_emp;

