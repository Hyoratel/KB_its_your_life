-- 1. sqldb 데이터베이스에서 다음 조건 처리
-- 1) 사용자별로 구매 이력을 출력
-- 2) 모든 컬럼 출력
-- 3) 구매 이력이 없는 정보는 출력하지 X
select *
from buytbl
inner join usertbl
on buytbl.userID = usertbl.userID;

-- 2.결과에서 userID가 'JYP'인 데이터만 출력
select *
from buytbl b
inner join usertbl u
on b.userID = u.userid
where b.userid = 'JYP';

-- 3.sqldb 데이터베이스에서 다음 조건을 처리하세요.
-- 1) 각 사용자별로 구매 이력을 출력(left = usertbl)
-- 2) 연결 컬럼은 userID로 함
-- 3) 결과를 userID를 기준으로 오름차순으로 정렬
-- 4) 구매이력이 없는 사용자도 출력 (left outer join)
-- 5) userID, name, prodName, addr, 연락처를 다음과 같이 출력
select u.userid, u.name, b.prodName, u.addr, concat(u.mobile1, u.mobile2) '연락처'
from usertbl u
left outer join buytbl b
on u.userid = b.userid
order by u.userid;

-- 4.sqldb 사용자를 모두 조회하되 전화가 없는 사람은 제외하고 출력
select name, concat(u.mobile1, u.mobile2) '전화번호'
from usertbl u
where name not in (select name from usertbl where mobile1 is null);
-- where mobile1 is not null and mobile2 is not null;

-- 5.sqldb 사용자를 모두 조회하되 전화가 없는 사람만 출력
select name, concat(u.mobile1, u.mobile2) '전화번호'
from usertbl u
where name in(select name from usertbl where mobile1 is null);