use sqldb;

-- 1. 다음 결과가 나오도록 buytbl에 대한 SQL 문을 각각 작성하세요.
select userid '사용자 아이디', sum(amount) '총 구매 개수'
from buytbl
group by userid;

select userid '사용자 아이디', sum(amount*price) '총 구매액'
from buytbl
group by userid;

-- 2. 다음 결과가 나오도록 buytbl에 대한 SQL 문을 각각 작성하세요.
select avg(amount) '평균 구매 개수'
from buytbl;

select userid, avg(amount) '평균 구매 개수'
from buytbl
group by userid;

-- 3. 다음 결과가 나오도록 usertbl에 대한 SQL 문을 작성하세요
--   *가장 키가 큰 사람과 가장 키가 작은 사람 출력
select name, height
from usertbl
where height in(
(select max(height) from usertbl),
(select min(height) from usertbl)
);

-- 4.다음 결과가 나오도록 usertbl에 대한 SQL 문을 작성하세요
select count(mobile2) '휴대폰이 있는 사용자'
from usertbl;

-- 5.buytbl 테이블로 다음을 처리하세요.
-- 1)사용자별 총 구매액 출력
select userid 사용자, sum(amount * price) 총구매액
from buytbl
group by userid;

-- 2)총 구매액이 1,000이상인 사용자만 출력
select userid 사용자, sum(amount * price) 총구매액
from buytbl
group by userid
having sum(amount * price) > 1000;

-- 6. world 데이터베이스에서 다음 질문을 처리하세요.
use world;
-- 1) city 테이블에서 국가코드 'KOR'인 도시들의 인구수 총합
select sum(population)
from city
where countrycode = 'KOR';

-- 2) city 테이블에서 국가코드 'KOR'인 도시들의 인구수 중 최솟값을 구하시오.(테이블 필드는 "최솟값"으로 표시)
select min(population) 최솟값
from city
where countrycode = 'KOR';

-- 3) city 테이블에서 국가코드가 'KOR'인 도시들의 평균
select avg(population)
from city
where countrycode = 'KOR';

-- 4) city 테이블에서 국가코드 'KOR'인 도시들의 인구수 중 최대값(테이블 필드는 "최대값"으로 표시)
select max(population) 최대값
from city
where countrycode = 'KOR';

-- 5) country 테이블 각 레코드의 Name 칼럼의 글자수를 표시
select length(name)
from country;

-- 6) country 테이블의 나라명(Name 칼럼)을 앞 세글자만 대문자로 표시하시오.
-- mid 잘라내기 / upper 대문자로
select upper(mid(name, 1, 3)) from country;

-- 7) country 테이블의 기대수명(LifeExpectancy)을 소수점 첫째자리에서 반올림해서 표시.
select name as 이름, round(lifeexpectancy,1) 기대수명
from country;

-- 심화2
-- 7.employees db에서 각 부서별 관리자를 출력하세요. (현 재직자만)
use employees;
select *
from dept_manager
where to_date = '9999-01-01';

-- 8.부서번호 d005 부서의 현재 관리자 정보를 출력하세요.
select *
from employees
where emp_no =(
select emp_no from dept_manager
where to_date='9999-01-01' and dept_no='d005');

-- 9.employees 테이블에서 페이지네이션으로 페이지를 추출하려고 한다. 다음 조건하에서 8번 페이지의 데이터를 출력하세요.
-- *입사일을 내림차순 정렬 / 한 페이지당 20명 정보 출력
select *
from employees
order by hire_date desc
limit 140, 20; -- offset, amount (141~160)

-- 10.employees db에서 재직자의 총 수를 구하시오.
-- *재직자의 to_date값은 '9999-01-01'로 저장되어 있음.
select count(*)
from dept_emp
where to_date = '9999-01-01';

-- 11.employees db에서 재직자의 평균 급여를 출력하시오.
select avg(salary)
from salaries
where to_date = '9999-01-01';

-- 12.재직자 전체 평균 급여 보다 급여를 더 많이 받는 재직자를 출력하세요.
select *
from salaries
where to_date = '9999-01-01' and salary > (
select avg(salary)
from salaries
where to_date = '9999-01-01');

-- 13.employees db에서 각 부서별 재직자의 수를 구하시오
-- *부서번호로 구분하고 부서번호로 오름 차순 정렬하여 출력
select dept_no, count(*)
from dept_emp
where to_date = '9999-01-01'
group by dept_no
order by dept_no;